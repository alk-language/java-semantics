package ast.stmt;

import org.antlr.v4.runtime.*;

public class EnsureAST
extends StmtAST
{

   public EnsureAST(ParserRuleContext ctx)
   {
      super(ctx);
   }

   @Override
   public String toString()
   {
      String expr = super.getChildCount() > 0 ? super.getChild(0).toString() : "";
      return "@ensures " + expr + ";";
   }
}
