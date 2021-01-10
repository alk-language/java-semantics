package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.PostfixVisitorIface;
import visitor.ifaces.expr.StructVisitorIface;

public class StructAST
extends AST
{

    public StructAST(ParserRuleContext ctx)
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
        if (visitor instanceof StructVisitorIface)
            return ((StructVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
