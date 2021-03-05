package ast.expr;

import ast.attr.IdASTAttr;
import grammar.alkParser;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.RefIDVisitorIface;
import visitor.ifaces.expr.SymIDVisitorIface;

public class SymIDAST
extends ExpressionAST
{

    public SymIDAST(alkParser.SymIDContext ctx)
    {
        super(ctx);
        this.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.ID().getText()));
    }

    public SymIDAST(String id)
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
        if (visitor instanceof SymIDVisitorIface)
        {
            return ((SymIDVisitorIface<T>) visitor).visit(this);
        }

        return super.accept(visitor);
    }
}

