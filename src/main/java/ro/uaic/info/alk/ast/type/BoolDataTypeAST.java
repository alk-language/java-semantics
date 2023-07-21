package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.ast.ASTContext;

import java.lang.ref.SoftReference;

public class BoolDataTypeAST
extends DataTypeAST
{
    public static SoftReference<BoolDataTypeAST> INSTANCE;

    public BoolDataTypeAST(ASTContext ctx)
    {
        super(ctx);
    }

   public static BoolDataTypeAST getInstance()
   {
      BoolDataTypeAST ast;
      if (INSTANCE == null || (ast = INSTANCE.get()) == null)
      {
         ast = new BoolDataTypeAST(null);
         INSTANCE = new SoftReference<>(ast);
      }

      return ast;
   }

   @Override
    public String toString()
    {
        return "bool";
    }

    @Override
    public Expr<?> makeExpr(Context ctx, String id)
    {
        return ctx.mkConst(id, ctx.getBoolSort());
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.getBoolSort();
    }
}
