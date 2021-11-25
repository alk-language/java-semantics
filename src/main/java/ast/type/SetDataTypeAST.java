package ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class SetDataTypeAST
extends DataTypeAST
implements IterableDataTypeAST
{
    public SetDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "set<" + getChild(0).toString() +">";
    }

    @Override
    public Expr<?> makeExpr(Context ctx, String id)
    {
        return ctx.mkArrayConst(id, getTypeAst().getSort(ctx), ctx.getBoolSort());
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.mkArraySort(getTypeAst().getSort(ctx), ctx.getBoolSort());
    }

    @Override
    public DataTypeAST getTypeAst()
    {
        return (DataTypeAST) getChild(0);
    }
}
