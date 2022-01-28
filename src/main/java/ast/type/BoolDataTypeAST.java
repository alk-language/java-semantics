package ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class BoolDataTypeAST
extends DataTypeAST
{
    public BoolDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
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
