package ast.expr;

import ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FactorPointIdIface;

public class FactorPointIdAST
extends ExpressionAST
{
    public FactorPointIdAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return super.getChild(0) + "." + super.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FactorPointIdIface)
            return ((FactorPointIdIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
