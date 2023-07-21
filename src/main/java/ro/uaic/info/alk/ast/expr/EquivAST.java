package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.EquivVisitorIface;

public class EquivAST
   extends ExpressionAST
{

    public EquivAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(ctx);
    }

    @Override
    public String toString()
    {
        return getChild(0) + " <==> " + getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof EquivVisitorIface)
            return ((EquivVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
