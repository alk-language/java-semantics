package execution;

import ast.*;
import ast.attr.*;
import ast.expr.*;
import ast.stmt.*;
import execution.parser.constants.*;
import execution.parser.exceptions.*;
import util.exception.*;

import java.util.*;


public class Optimizer
{

   public static AST gatherMain(AST root, boolean addMainCall)
   {
      if (!(root instanceof StmtSeqAST))
         throw new InternalException("Bad gatherMain optimization!");
      AST newRoot = new StmtSeqAST(root.getCtx());
      FunctionDeclAST mainFnc = new FunctionDeclAST(root.getCtx());
      mainFnc.addAttribute(ParamASTAttr.class, new ParamASTAttr());
      mainFnc.addAttribute(IdASTAttr.class, new IdASTAttr(Constants.MAIN_FNC));
      StmtSeqAST body = new StmtSeqAST(root.getCtx());
      mainFnc.addChild(body);
      for (int i = 0; i < root.getChildCount(); i++)
      {
         if (root.getChild(i) instanceof FunctionDeclAST)
         {
            newRoot.addChild(root.getChild(i));
            continue;
         }
         AST tree = root.getChild(i);
         body.addChild(tree);
      }
      newRoot.addChild(mainFnc);
      if (addMainCall)
      {
         AST exprStmt = new ExprStmtAST(root.getCtx());
         AST fncCall = new FunctionCallAST(root.getCtx());
         exprStmt.addChild(fncCall);
         fncCall.addAttribute(IdASTAttr.class, new IdASTAttr(Constants.MAIN_FNC));
         newRoot.addChild(fncCall);
      }
      return newRoot;
   }

   public static void processSpecification(AST root)
   {
      List<FunctionDeclAST> fncs = ASTHelper.getFunctions(root, false);
      for (FunctionDeclAST decl : fncs)
      {
         List<RequireAST> init = new ArrayList<>();
         ASTVisitor<List<RequireAST>> visitor = new ASTVisitor<>(init);
         visitor.registerPre((tree) -> tree instanceof RequireAST, (tree, payload) -> {
            payload.add((RequireAST) tree);
         });
         visitor.visit(decl);
         for (RequireAST ast : init)
         {
            decl.addRequires(ast.getChild(0));
         }
         new ASTRemover().visit(decl, (tree) -> tree instanceof RequireAST);
      }

      for (FunctionDeclAST decl : fncs)
      {
         List<EnsureAST> init = new ArrayList<>();
         ASTVisitor<List<EnsureAST>> visitor = new ASTVisitor<>(init);
         visitor.registerPre((tree) -> tree instanceof EnsureAST, (tree, payload) -> {
            payload.add((EnsureAST) tree);
         });
         visitor.visit(decl);
         for (EnsureAST ast : init)
         {
            decl.addEnsures(ast.getChild(0));
         }

         new ASTRemover().visit(decl, (tree) -> tree instanceof EnsureAST);
      }
   }
}
