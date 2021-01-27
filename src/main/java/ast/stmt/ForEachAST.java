package ast.stmt;

import ast.AST;
import ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.ForEachVisitorIface;

public class ForEachAST
extends StmtAST
{

    public ForEachAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getSource()
    {
        return super.getChild(0);
    }

    public AST getStatement()
    {
        return super.getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ForEachVisitorIface)
            return ((ForEachVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr attr = super.getAttribute(IdASTAttr.class);
        return "for each " + attr.getId() + " from " + getSource().toString() + "\n" + getStatement().toString();
    }
}
