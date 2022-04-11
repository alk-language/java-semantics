package ast.stmt;

import org.antlr.v4.runtime.*;

public class RequireAST
extends StmtAST
{

   public RequireAST(ParserRuleContext ctx)
   {
      super(ctx);
   }

   @Override
   public String toString()
   {
      String expr = super.getChildCount() > 0 ? super.getChild(0).toString() : "";
      return "@requires " + expr + ";";
   }
}
