package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.IntVisitorIface;

public class IntAST
extends AST
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
