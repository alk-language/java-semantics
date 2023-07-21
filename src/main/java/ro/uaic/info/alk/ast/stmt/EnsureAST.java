package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;

public class EnsureAST
extends StmtAST
{

   public EnsureAST(ASTContext ctx)
   {
      super(ctx);
   }

   @Override
   public String toString()
   {
      String expr = super.getChildCount() > 0 ? super.getChild(0).toString() : "";
      // TODO: this should include data type assertions?
      return "@ensures " + expr + ";" + System.lineSeparator();
   }
}
