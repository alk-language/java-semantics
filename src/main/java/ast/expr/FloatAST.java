package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FloatVisitorIface;

public class FloatAST
extends ExpressionAST
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
