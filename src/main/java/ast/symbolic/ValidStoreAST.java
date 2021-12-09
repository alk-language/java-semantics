package ast.symbolic;

import ast.expr.ExpressionAST;
import ast.type.BoolDataType;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.ValidStoreVisitorIface;

public class ValidStoreAST
extends ExpressionAST
{
    public ValidStoreAST(ParserRuleContext ctx)
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
        if (visitor instanceof ValidStoreVisitorIface)
            return ((ValidStoreVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "validStore(" + getChild(0) + ", " + getChild(1) + ", " + getChild(2) + ")";
    }
}
