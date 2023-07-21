package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.ast.ASTContext;

public class StringDataTypeAST
extends DataTypeAST
{
   public StringDataTypeAST(ASTContext ctx)
   {
      super(ctx);
   }

   @Override
   public Expr<?> makeExpr(Context ctx, String id)
   {
      return null;
   }

   @Override
   public Sort getSort(Context ctx)
   {
      return null;
   }

   @Override
   public String toString()
   {
      return null;
   }
}
