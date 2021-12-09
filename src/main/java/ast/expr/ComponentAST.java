package ast.expr;

import ast.attr.IdASTAttr;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ComponentVisitorIface;

public class ComponentAST
extends ExpressionAST
{
    public ComponentAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type for structure components");
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ComponentVisitorIface)
            return ((ComponentVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr attr = getAttribute(IdASTAttr.class);
        return attr.getId() + "->" + super.getChild(0);
    }

}
