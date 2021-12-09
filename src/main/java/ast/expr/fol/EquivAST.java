package ast.expr.fol;

import ast.expr.ExpressionAST;
import ast.type.BoolDataType;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.EquivVisitorIface;
import visitor.ifaces.expr.ImpliesVisitorIface;

public class EquivAST
extends ExpressionAST
{

    public EquivAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataType(ctx);
    }

    @Override
    public String toString()
    {
        return getChild(0) + " <==> " + getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof EquivVisitorIface)
            return ((EquivVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
