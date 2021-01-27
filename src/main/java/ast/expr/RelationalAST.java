package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.RelationalVisitorIface;

public class RelationalAST
extends ExpressionAST
{
    public RelationalAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof RelationalVisitorIface)
            return ((RelationalVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
