package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.parser.AlkParser;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.RefIDVisitorIface;

public class RefIDAST
extends ExpressionAST
{
    // TODO, don't make it sependent upon REFIDCONTEXT (antlr)
    public RefIDAST(AlkParser.RefIDContext ctx)
    {
        super(ctx);
        this.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.ID().getText()));
    }

    public RefIDAST(String id)
    {
        super(null);
        this.addAttribute(IdASTAttr.class, new IdASTAttr(id));
        super.text = id;
    }

    public void setId(String id)
    {
        IdASTAttr attr = new IdASTAttr(id);
        super.addAttribute(IdASTAttr.class, attr);
    }

    public String getId()
    {
        return super.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public String toString()
    {
        return getText();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof RefIDVisitorIface)
            return ((RefIDVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return dtp.getDataType(text != null ? text : getAttribute(IdASTAttr.class).getId());
//        throw new InternalException("Can't detect data type for id: " + getId());
    }
}
