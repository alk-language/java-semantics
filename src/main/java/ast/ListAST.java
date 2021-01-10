package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.ListVisitorIface;

public class ListAST
extends AST
{
    public ListAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "< " + AST.getCSV(this) + " >";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ListVisitorIface)
            return ((ListVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
