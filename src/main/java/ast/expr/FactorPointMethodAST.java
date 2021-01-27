package ast.expr;

import ast.attr.BuiltInMethodASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FactorPointMethodVisitorIface;

public class FactorPointMethodAST
extends ExpressionAST
{
    public FactorPointMethodAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return super.getChild(0) + "." + super.getAttribute(BuiltInMethodASTAttr.class).getMethod();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FactorPointMethodVisitorIface)
            return ((FactorPointMethodVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
