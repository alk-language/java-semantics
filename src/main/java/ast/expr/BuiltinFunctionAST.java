package ast.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.BuiltInFunctionVisitorIface;

public class BuiltinFunctionAST
extends ExpressionAST
{
    public BuiltinFunctionAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "Builtin-Function";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BuiltInFunctionVisitorIface)
            return ((BuiltInFunctionVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
