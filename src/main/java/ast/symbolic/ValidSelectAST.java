package ast.symbolic;

import ast.expr.ExpressionAST;
import ast.type.BoolDataType;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.ValidSelectVisitorIface;

public class ValidSelectAST
extends ExpressionAST
{
    public ValidSelectAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataType(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ValidSelectVisitorIface)
            return ((ValidSelectVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "validSelect(" + getChild(0) + ", " + getChild(1) + ")";
    }
}
