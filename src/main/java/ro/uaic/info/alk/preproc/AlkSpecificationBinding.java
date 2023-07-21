package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTHelper;
import ro.uaic.info.alk.ast.ASTVisitor;
import ro.uaic.info.alk.ast.stmt.EnsureAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.ast.stmt.RequireAST;

import java.util.ArrayList;
import java.util.List;

public class AlkSpecificationBinding
implements Preprocessor
{
   @Override
   public AST preprocess(AST root)
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

      return root;
   }
}
