package ast.expr.fol;

import ast.expr.ExpressionAST;
import ast.type.BoolDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ImpliesVisitorIface;

public class ImpliesAST
extends ExpressionAST
{

    public ImpliesAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(ctx);
    }

    @Override
    public String toString()
    {
        return getChild(0) + " ==> " + getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ImpliesVisitorIface)
            return ((ImpliesVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
