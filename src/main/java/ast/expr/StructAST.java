package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.StructVisitorIface;

public class StructAST
extends ExpressionAST
{

    public StructAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "{" + AST.getSV(this, " ") + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StructVisitorIface)
            return ((StructVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
