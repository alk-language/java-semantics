package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ResultVisitorIface;

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
