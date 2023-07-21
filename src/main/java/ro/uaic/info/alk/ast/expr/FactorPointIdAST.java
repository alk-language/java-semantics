package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.FactorPointIdIface;

public class FactorPointIdAST
extends ExpressionAST
{
    public FactorPointIdAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type for factor point id exrpressions!");
    }

    @Override
    public String toString()
    {
        return super.getChild(0) + "." + super.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FactorPointIdIface)
            return ((FactorPointIdIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
