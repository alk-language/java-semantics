package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;

import java.util.function.*;

public class ASTRemover
{
   public void visit(AST root, Function<AST, Boolean> checker)
   {
      for (int i = 0; i < root.getChildCount(); i++)
      {
         if (checker.apply(root.getChild(i)))
         {
            root.deleteChild(i);
            i--;
         }
         else
         {
            visit(root.getChild(i), checker);
         }
      }
   }
}
