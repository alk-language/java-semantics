package ast.expr;

import ast.attr.IdASTAttr;
import grammar.alkParser;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.RefIDVisitorIface;

public class RefIDAST
extends ExpressionAST
{

    public RefIDAST(alkParser.RefIDContext ctx)
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
}
