package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.ComponentVisitorIface;

public class ComponentAST
extends AST
{
    public ComponentAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ComponentVisitorIface)
            return ((ComponentVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return super.getChild(0) + "->" + super.getChild(1);
    }

}
