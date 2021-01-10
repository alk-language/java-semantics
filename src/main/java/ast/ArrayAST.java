package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.VisitorIface;
import visitor.ifaces.expr.ArrayVisitorIface;

public class ArrayAST
extends AST
{
    public ArrayAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "[" + AST.getCSV(this) + "]";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ArrayVisitorIface)
            return ((ArrayVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
