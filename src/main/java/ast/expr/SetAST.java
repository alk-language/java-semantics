package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.SetVisitorIface;

public class SetAST
extends ExpressionAST
{
    public SetAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "{" + AST.getCSV(this) + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SetVisitorIface)
            return ((SetVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
