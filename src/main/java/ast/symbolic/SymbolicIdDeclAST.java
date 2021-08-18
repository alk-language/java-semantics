package ast.symbolic;

import ast.attr.IdASTAttr;
import ast.attr.TypeASTAttr;
import ast.stmt.StmtAST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.SuccessVisitorIface;
import visitor.ifaces.stmt.SymbolicIdDeclVisitorIface;

public class SymbolicIdDeclAST
extends StmtAST
{
    public SymbolicIdDeclAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SymbolicIdDeclVisitorIface)
            return ((SymbolicIdDeclVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr idAttr = getAttribute(IdASTAttr.class);
        return "$" + idAttr.getId() + " : " + getChild(0).toString();
    }
}
