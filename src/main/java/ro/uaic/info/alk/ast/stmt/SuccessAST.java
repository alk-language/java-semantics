package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.SuccessVisitorIface;

public class SuccessAST
extends StmtAST
{
    public SuccessAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SuccessVisitorIface)
            return ((SuccessVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "success;" + System.lineSeparator();
    }
}
