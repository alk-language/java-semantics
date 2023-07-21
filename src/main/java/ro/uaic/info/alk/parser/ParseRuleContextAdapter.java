package ro.uaic.info.alk.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.ASTContext;

public class ParseRuleContextAdapter
implements ASTContext
{
   private final ParserRuleContext ctx;

   public ParseRuleContextAdapter(ParserRuleContext ctx)
   {
      this.ctx = ctx;
   }

   @Override
   public int getLine()
   {
      return ctx.getStart().getLine();
   }

   @Override
   public int getCol()
   {
      return ctx.getStart().getCharPositionInLine();
   }

   @Override
   public String getText()
   {
      return ctx.getText();
   }
}
