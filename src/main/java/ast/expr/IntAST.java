package ast.expr;

import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import ast.type.IntDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.IntVisitorIface;

public class IntAST
extends ExpressionAST
{
    public IntAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public IntAST(String text)
    {
        super(null);
        super.text = text;
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new IntDataTypeAST(null);
    }

    @Override
    public String toString()
    {
        return getText();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof IntVisitorIface)
            return ((IntVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
