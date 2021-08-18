package ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class IntDataTypeAST
extends DataTypeAST
{
    public IntDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
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
