package ast.stmt;

import ast.AST;
import ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.UniformVisitorIface;

public class UniformAST
extends StmtAST
implements BreakableStmtAST
{

    public UniformAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getSource()
    {
        return super.getChild(0);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof UniformVisitorIface)
            return ((UniformVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr attr = super.getAttribute(IdASTAttr.class);
        return "uniform  " + attr.getId() + " from " + getSource().toString() + ";";
    }
}
