package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.ContinueVisitorIface;

public class ContinueAST
extends StmtAST
implements BreakableStmtAST
{

    public ContinueAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ContinueVisitorIface)
            return ((ContinueVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "continue;";
    }
}

