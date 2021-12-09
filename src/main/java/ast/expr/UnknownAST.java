package ast.expr;

import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.IncompleteASTException;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.UnknownVisitorIface;

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
