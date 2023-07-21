package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTHelper;
import ro.uaic.info.alk.ast.ASTProcessor;
import ro.uaic.info.alk.ast.ASTVisitor;
import ro.uaic.info.alk.ast.attr.GeneratedAttr;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.expr.FunctionCallAST;
import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.ast.stmt.BlockAST;
import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.ast.stmt.ReturnAST;

import java.util.*;

public class FlattenFunctions
implements Preprocessor
{
   @Override
   public AST preprocess(AST root)
   {
      List<FunctionDeclAST> fncsList = ASTHelper.getFunctions(root, false);
      Map<String, FunctionDeclAST> fnc = new HashMap<>();
      for (FunctionDeclAST f : fncsList)
      {
         fnc.put(f.getAttribute(IdASTAttr.class).getId(), f);
      }
      ASTVisitor<String[]> visitor = new ASTVisitor<>(new String[] { null });

      visitor.registerPre((tree) -> true, (tree, payload) -> {
         List<AST> children = tree.getChildren();
         children.replaceAll((child) -> {
            if (child instanceof ReturnAST)
            {
               AST wrapper = new ExprStmtAST(null);
               AST assign = new AssignmentAST(null);
               assign.addChild(new RefIDAST("\\result"));
               assign.addChild(child.getChild(0));

               OpsASTAttr attr = new OpsASTAttr();
               attr.add(Operator.ASSIGN);
               assign.addAttribute(OpsASTAttr.class, attr);

               wrapper.addChild(assign);
               return wrapper;
            }
            return child;
         });
      });

      Deque<AST> blocks = new ArrayDeque<>();
      visitor.registerPre((tree) -> tree instanceof BlockAST, (tree, payload) -> {
         blocks.add(tree);
      });
      visitor.registerPost((tree) -> tree instanceof BlockAST, (tree, payload) -> {
         blocks.pop();
      });

      visitor.registerPre((tree) -> true, (tree, payload) -> {
         List<AST> children = tree.getChildren();
         children.replaceAll((child) -> {
            if (child instanceof FunctionCallAST)
            {
               AST block = blocks.peek();
               String id = child.getAttribute(IdASTAttr.class).getId();
               AST refId = new RefIDAST(id + "-\\result");
               refId.addAttribute(GeneratedAttr.class, new GeneratedAttr());
               
               FunctionDeclAST function = fnc.get(id);

               for (int i = 0; i < child.getChildCount(); i++)
               {
                  AST param = child.getChild(i);
                  AST wrapper = new ExprStmtAST(null);
                  AST assign = new AssignmentAST(null);
                  String paramName = function.getAttribute(ParamASTAttr.class).getParameter(i).getName();
                  AST paramAST = new RefIDAST(id + "-" + paramName);
                  paramAST.addAttribute(GeneratedAttr.class, new GeneratedAttr());
                  assign.addChild(paramAST);
                  assign.addChild(param);

                  OpsASTAttr attr = new OpsASTAttr();
                  attr.add(Operator.ASSIGN);
                  assign.addAttribute(OpsASTAttr.class, attr);

                  wrapper.addChild(assign);
                  assert block != null;
                  block.addChild(wrapper);
               }

               return refId;
            }

            return child;
         });
      });

      visitor.visit(root);

      return root;
   }
}
