package ro.uaic.info.alk.ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.AST;

public class IncludeAST
   extends AST
{
   public IncludeAST(ParserRuleContext ctx)
   {
      super(ctx);
   }

   @Override
   public String toString()
   {
      return "#include " + getChild(0);
   }
}
