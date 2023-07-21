package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.ArrayExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.ASTContext;

public class ArrayDataTypeAST
extends DataTypeAST
implements IterableDataTypeAST
{
    public ArrayDataTypeAST()
    {
        this(null);
    }

    public ArrayDataTypeAST(ASTContext ctx)
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
        return "array<" + getChild(0).toString() +">";
    }

}
