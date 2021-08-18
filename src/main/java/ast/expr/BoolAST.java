package ast.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.BoolVisitorIface;

public class BoolAST
extends ExpressionAST
{
    public BoolAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public BoolAST(String text)
    {
        super(null);
        super.text = text;
    }

    @Override
    public String toString()
    {
        return getText();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BoolVisitorIface)
            return ((BoolVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
