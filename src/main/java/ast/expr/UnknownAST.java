package ast.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.UnknownVisitorIface;

public class UnknownAST
extends ExpressionAST
{
    public UnknownAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "?";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof UnknownVisitorIface)
            return ((UnknownVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
