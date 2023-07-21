package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.IntVisitorIface;

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
