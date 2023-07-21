package ro.uaic.info.alk.ast.symbolic;

import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.symbolic.ValidSelectVisitorIface;

public class ValidSelectAST
   extends ExpressionAST
{
    public ValidSelectAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ValidSelectVisitorIface)
            return ((ValidSelectVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "validSelect(" + getChild(0) + ", " + getChild(1) + ")";
    }
}
