package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;

public class RequireAST
extends StmtAST
{

   public RequireAST(ASTContext ctx)
   {
      super(ctx);
   }

   @Override
   public String toString()
   {
      String expr = getChildCount() > 0 ? getChild(0).toString() : "";
      // TODO: this should include data type assertions?
      return "@requires " + expr + ";" + System.lineSeparator();
   }
}
