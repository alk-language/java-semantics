package ast.symbolic;

import ast.stmt.StmtAST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.SymbolicDeclsVisitorIface;

public class SymbolicDeclsAST
extends StmtAST
{
    public SymbolicDeclsAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SymbolicDeclsVisitorIface)
            return ((SymbolicDeclsVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("symbolic ");
        for (int i = 0; i < getChildCount(); i++)
        {
            str.append(getChild(i).toString());
        }
        str.append( ";");
        return str.toString();
    }
}
