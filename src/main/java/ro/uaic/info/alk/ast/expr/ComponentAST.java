package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ComponentVisitorIface;

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
