package ast.expr;

import ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ComponentVisitorIface;

public class ComponentAST
extends ExpressionAST
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
        IdASTAttr attr = getAttribute(IdASTAttr.class);
        return attr.getId() + "->" + super.getChild(0);
    }

}
