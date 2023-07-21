package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.BoolVisitorIface;

public class BoolAST
extends ExpressionAST
{
    public BoolAST(ASTContext ctx)
    {
        super(ctx);
    }

    public BoolAST(boolean value)
    {
        super(null);
        super.text = value ? "true" : "false";
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return BoolDataTypeAST.getInstance();
    }

    @Override
    public String toString()
    {
        return getText();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BoolVisitorIface)
            return ((BoolVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
