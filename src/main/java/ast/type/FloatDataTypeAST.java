package ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class FloatDataTypeAST
extends DataTypeAST
{
    public FloatDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
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
