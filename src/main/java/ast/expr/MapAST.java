package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.MapVisitorIface;
import visitor.ifaces.expr.StructVisitorIface;

public class MapAST
extends ExpressionAST
{

    public MapAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type for structures.");
    }

    @Override
    public String toString()
    {
        return "{" + AST.getSV(this, " ") + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof MapVisitorIface)
            return ((MapVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}