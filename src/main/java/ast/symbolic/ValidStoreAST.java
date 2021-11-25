package ast.symbolic;

import ast.expr.ExpressionAST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.ValidStoreVisitorIface;

public class ValidStoreAST
extends ExpressionAST
{
    public ValidStoreAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ValidStoreVisitorIface)
            return ((ValidStoreVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "validStore(" + getChild(0) + ", " + getChild(1) + ", " + getChild(2) + ")";
    }
}
