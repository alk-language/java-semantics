package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.BuiltInFunctionASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.FloatDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.BuiltInFunctionVisitorIface;

public class BuiltinFunctionAST
extends ExpressionAST
{
    public BuiltinFunctionAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        BuiltInFunctionASTAttr attr = this.getAttribute(BuiltInFunctionASTAttr.class);
        StringBuilder base = new StringBuilder(attr.getFunction().toString().toLowerCase() + "(");
        for (int i = 0; i < this.getChildCount(); i++)
        {
            if (i > 0) base.append(", ");
            base.append(this.getChild(i).toString());
        }
        return base + ")";
    }

    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new FloatDataTypeAST(null);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BuiltInFunctionVisitorIface)
            return ((BuiltInFunctionVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
