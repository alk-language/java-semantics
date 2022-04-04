package ast.expr;

import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ResultVisitorIface;

public class ResultAST
extends ExpressionAST
{
    public ResultAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't find the data type of result!");
    }

    @Override
    public String toString()
    {
        return "\\result";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ResultVisitorIface)
            return ((ResultVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
