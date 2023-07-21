package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.ContinueVisitorIface;

public class ContinueAST
extends StmtAST
implements BreakableStmtAST
{

    public ContinueAST(ASTContext ctx)
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
        return "continue;" + System.lineSeparator();
    }
}

