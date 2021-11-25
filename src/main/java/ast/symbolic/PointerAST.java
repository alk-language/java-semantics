package ast.symbolic;

import ast.expr.ExpressionAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import execution.parser.env.Location;
import execution.types.alkInt.AlkInt;
import org.antlr.v4.runtime.ParserRuleContext;
import symbolic.SymbolicValue;
import util.exception.IncompleteASTException;
import util.types.Storable;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.symbolic.PointerVisitorIface;

public class PointerAST
extends ExpressionAST
{
    private final Location loc;

    public PointerAST(ParserRuleContext ctx, Location loc)
    {
        super(ctx);
        this.loc = loc;
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        Storable value = loc.toRValue();
        return ((ExpressionAST) SymbolicValue.toSymbolic(value).toAST()).getDataType(dtp);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof PointerVisitorIface)
            return ((PointerVisitorIface<T>) visitor).visit(this);

        if (loc.isUnknown())
        {
            throw new IncompleteASTException();
        }

        return SymbolicValue.toSymbolic(loc.toRValue()).toAST().accept(visitor);
    }

    @Override
    public String toString()
    {
        if (loc.isUnknown())
        {
            return "?";
        }
        return SymbolicValue.toSymbolic(loc.toRValue()).toAST().toString();
    }

    public Location getLocation()
    {
        return loc;
    }
}
