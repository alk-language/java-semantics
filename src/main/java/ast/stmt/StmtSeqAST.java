package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.StmtSeqVisitorIface;

public class StmtSeqAST
extends StmtAST
{
    public StmtSeqAST(ParserRuleContext ctx)
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
        for (int i = 0; i < super.getChildCount(); i++)
        {
            sb.append(super.getChild(i).toString()).append('\n');
        }
        return sb.toString();
    }
}
