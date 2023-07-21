package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.ArrayExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;

public class ListDataTypeAST
extends DataTypeAST
implements IterableDataTypeAST
{
    public ListDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public ArrayExpr makeExpr(Context ctx, String id)
    {
        return ctx.mkArrayConst(id, ctx.getIntSort(), getTypeAst().getSort(ctx));
    }

    @Override
    public Sort getSort(Context ctx)
    {
        return ctx.mkArraySort(ctx.getIntSort(), getTypeAst().getSort(ctx));
    }

    @Override
    public DataTypeAST getTypeAst()
    {
        return (DataTypeAST) getChild(0);
    }

    @Override
    public String toString()
    {
        return "list<" + getChild(0).toString() +">";
    }

}
