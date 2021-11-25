package ast.expr;

import ast.attr.IdASTAttr;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import grammar.alkParser;
import visitor.ifaces.VisitorIface;
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
        assert !id.startsWith("$");
        this.addAttribute(IdASTAttr.class, new IdASTAttr(id));
        super.text = id;
    }

    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return dtp.getDataType(getText());
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
        return "$" + getId();
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

