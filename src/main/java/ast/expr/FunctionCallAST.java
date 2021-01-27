package ast.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FunctionCallVisitorIface;

public class FunctionCallAST
extends ExpressionAST
{
    public FunctionCallAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FunctionCallVisitorIface)
            return ((FunctionCallVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "function call";
    }
}
