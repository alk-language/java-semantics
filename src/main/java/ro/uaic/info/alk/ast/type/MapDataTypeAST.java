package ro.uaic.info.alk.ast.type;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import org.antlr.v4.runtime.ParserRuleContext;

public class MapDataTypeAST
extends DataTypeAST
{
    public MapDataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "map<" + getChild(0).toString() +">";
    }

    @Override
    public Expr<?> makeExpr(Context ctx, String id)
    {
        throw new NotImplementedException("Map data type retrieval not implemented!");
    }

    @Override
    public Sort getSort(Context ctx)
    {
        throw new NotImplementedException("Map data type retrieval not implemented!");
    }
}
