package ast.symbolic;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.StoreVisitorIface;

public class StoreAST
extends AST
{
    public StoreAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StoreVisitorIface)
            return ((StoreVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "(store " + super.getChild(0) + " " + super.getChild(1) + " " + super.getChild(2) + ")";
    }
}
