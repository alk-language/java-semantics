package ast.expr;

import ast.attr.IdASTAttr;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FactorPointIdIface;

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
