package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.StmtSeqVisitorIface;

public class StmtSeqAST
extends StmtAST
{
    public StmtSeqAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StmtSeqVisitorIface)
            return ((StmtSeqVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        children.forEach((child) -> sb.append(child).append(System.lineSeparator()));
        return sb.toString();
    }
}
