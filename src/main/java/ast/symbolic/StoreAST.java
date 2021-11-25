package ast.symbolic;

import ast.expr.ExpressionAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import ast.type.IntDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.StoreVisitorIface;

public class StoreAST
extends ExpressionAST
{
    public StoreAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StoreVisitorIface)
            return ((StoreVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return ((ExpressionAST) super.getChild(0)).getDataType(dtp);
    }

    @Override
    public String toString()
    {
        if (super.getChildCount() < 3)
        {
            return "(store)";
        }
        return "(store " + super.getChild(0) + " " + super.getChild(1) + " " + super.getChild(2) + ")";
    }
}
