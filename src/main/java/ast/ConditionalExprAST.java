package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.ConditionalExprVisitorIface;

public class ConditionalExprAST
extends AST
{
    public ConditionalExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return getCondition().toString() + " ? " +
               getThenExpression().toString() + " : " + getElseExpression().toString();
    }

    public AST getCondition()
    {
        return super.getChild(0);
    }

    public AST getThenExpression()
    {
        return super.getChild(1);
    }

    public AST getElseExpression()
    {
        return super.getChild(2);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ConditionalExprVisitorIface)
            return ((ConditionalExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
