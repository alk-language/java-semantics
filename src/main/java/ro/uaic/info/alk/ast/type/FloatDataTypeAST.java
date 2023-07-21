package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.ast.ASTContext;

import java.lang.ref.SoftReference;

public class FloatDataTypeAST
extends DataTypeAST
{
    private static SoftReference<FloatDataTypeAST> INSTANCE;

    public FloatDataTypeAST(ASTContext ctx)
    {
        super(ctx);
    }


    public static FloatDataTypeAST getInstance()
    {
       FloatDataTypeAST ast;
       if (INSTANCE == null || (ast = INSTANCE.get()) == null)
       {
          ast = new FloatDataTypeAST(null);
          INSTANCE = new SoftReference<>(ast);
      }
       return ast;
    }

   @Override
    public Expr<?> makeExpr(Context ctx, String id)
    {
        return ctx.mkConst(id, ctx.getRealSort());
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.getRealSort();
    }

    @Override
    public String toString()
    {
        return "float";
    }
}
