package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.UnknownVisitorIface;

public class UnknownAST
extends ExpressionAST
{
    public UnknownAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type of unknown value");
    }

    @Override
    public String toString()
    {
        return "?";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof UnknownVisitorIface)
            return ((UnknownVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
