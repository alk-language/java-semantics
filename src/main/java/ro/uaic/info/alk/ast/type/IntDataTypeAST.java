package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.ast.ASTContext;

import java.lang.ref.SoftReference;

public class IntDataTypeAST
extends DataTypeAST
{
    private static SoftReference<IntDataTypeAST> INSTANCE;

    public IntDataTypeAST(ASTContext ctx)
    {
        super(ctx);
    }

    public static IntDataTypeAST getInstance()
    {
        IntDataTypeAST ast;
        if (INSTANCE == null || (ast = INSTANCE.get()) == null)
        {
            ast = new IntDataTypeAST(null);
            INSTANCE = new SoftReference<>(ast);
        }
        return ast;
    }

    public Expr<IntSort> makeExpr(Context ctx, String id)
    {
        return ctx.mkConst(id, ctx.getIntSort());
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.getIntSort();
    }

    @Override
    public String toString()
    {
        return "int";
    }
}
