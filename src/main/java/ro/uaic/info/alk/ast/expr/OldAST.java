package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.OldVisitorIface;

public class OldAST
extends ExpressionAST
{
    public OldAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't find the data type of old function!");
    }

    @Override
    public String toString()
    {
        return "\\old(" + getAttribute(IdASTAttr.class).getId() + ")";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof OldVisitorIface)
            return ((OldVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}

