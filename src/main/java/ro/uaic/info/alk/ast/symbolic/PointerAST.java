package ro.uaic.info.alk.ast.symbolic;

import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.storage.Location;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.exeptions.IncompleteASTException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.symbolic.PointerVisitorIface;

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
        if (loc == null)
        {
            throw new InternalException("Can't detect data type of incomplete AST!");
        }
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
