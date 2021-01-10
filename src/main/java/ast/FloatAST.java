package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.FloatVisitorIface;

public class FloatAST
extends AST
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
