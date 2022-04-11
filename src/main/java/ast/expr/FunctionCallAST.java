package ast.expr;

import ast.attr.*;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FunctionCallVisitorIface;

public class FunctionCallAST
extends ExpressionAST
{
    public FunctionCallAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type of function call!");
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FunctionCallVisitorIface)
            return ((FunctionCallVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return getAttribute(IdASTAttr.class).getId() + "(...)";
    }
}
