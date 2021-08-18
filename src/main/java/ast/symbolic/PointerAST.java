package ast.symbolic;

import ast.AST;
import execution.parser.env.Location;
import org.antlr.v4.runtime.ParserRuleContext;
import symbolic.SymbolicValue;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.PointerVisitorIface;

public class PointerAST
extends AST
{
    Location loc;

    public PointerAST(ParserRuleContext ctx, Location loc)
    {
        super(ctx);
        this.loc = loc;
    }


    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof PointerVisitorIface)
            return ((PointerVisitorIface<T>) visitor).visit(this);

        return SymbolicValue.toSymbolic(loc.toRValue()).toAST().accept(visitor);
    }

    @Override
    public String toString()
    {
        return SymbolicValue.toSymbolic(loc.toRValue()).toAST().toString();
    }

    public Location getLocation()
    {
        return loc;
    }
}
