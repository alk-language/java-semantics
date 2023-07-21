package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;

import java.util.stream.Collectors;

public abstract class CompoundTypeAST
extends ExpressionAST
{
   public CompoundTypeAST(ASTContext ctx)
   {
      super(ctx);
   }

   protected String getCSV()
   {
      return children.stream()
                     .map(AST::toString)
                     .collect(Collectors.joining(", "));
   }
}
