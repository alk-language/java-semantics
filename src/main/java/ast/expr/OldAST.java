package ast.expr;

import ast.attr.IdASTAttr;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.OldVisitorIface;
import visitor.ifaces.expr.ResultVisitorIface;

public class OldAST
extends ExpressionAST
{
    public OldAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't find the data type of old function!");
    }

    @Override
    public String toString()
    {
        return "\\old(" + getAttribute(IdASTAttr.class).getId() + ")";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof OldVisitorIface)
            return ((OldVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}

