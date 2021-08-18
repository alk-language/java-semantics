package ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class ArrayDataTypeAST
extends DataTypeAST
{
    public ArrayDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public Expr<?> makeExpr(Context ctx, String id)
    {
        return ctx.mkArrayConst(id, ctx.getIntSort(), getTypeAst().getSort(ctx));
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.mkArraySort(ctx.getIntSort(), getTypeAst().getSort(ctx));
    }

    private DataTypeAST getTypeAst()
    {
        return (DataTypeAST) getChild(0);
    }

    @Override
    public String toString()
    {
        return "array<" + getChild(0).toString() +">";
    }
}
