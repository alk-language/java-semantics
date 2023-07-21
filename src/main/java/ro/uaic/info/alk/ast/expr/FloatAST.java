package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.FloatDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.FloatVisitorIface;

public class FloatAST
extends ExpressionAST
{
    public FloatAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public FloatAST(String text)
    {
        super(null);
        this.text = text;
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new FloatDataTypeAST(null);
    }

    @Override
    public String toString()
    {
        return getText();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FloatVisitorIface)
            return ((FloatVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
