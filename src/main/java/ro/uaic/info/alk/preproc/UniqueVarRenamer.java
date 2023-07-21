package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTVisitor;
import ro.uaic.info.alk.ast.attr.GeneratedAttr;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.util.functions.Parameter;

public class UniqueVarRenamer
implements Preprocessor
{
   @Override
   public AST preprocess(AST root)
   {
      ASTVisitor<String[]> visitor = new ASTVisitor<>(new String[] { null });
      visitor.registerPre((tree) -> tree instanceof FunctionDeclAST, (tree, payload) -> {
         ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
         String id = tree.getAttribute(IdASTAttr.class).getId();
         for (int i = 0; i < attr.getParamCount(); i++)
         {
            Parameter param = attr.getParameter(i);
            param.setName(id + "-" + param.getName());
         }
         payload[0] = id;
      });
      visitor.registerPost((tree) -> tree instanceof FunctionDeclAST, (tree, payload) -> {
         payload[0] = null;
      });
      visitor.registerPre((tree) -> tree instanceof RefIDAST, (tree, payload) -> {
         if (tree.hasAttribute(GeneratedAttr.class))
         {
            return;
         }
         IdASTAttr attr = tree.getAttribute(IdASTAttr.class);
         attr.setId(payload[0] == null ? attr.getId() : payload[0] + "-" + attr.getId());
      });
      visitor.visit(root);

      return root;
   }
}
