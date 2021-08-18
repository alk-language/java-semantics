package ast.symbolic;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.symbolic.SelectVisitorIface;

public class SelectAST
extends AST
{
    public SelectAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SelectVisitorIface)
            return ((SelectVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "(select " + super.getChild(0) + " " + super.getChild(1) + ")";
    }
}
