package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.ForVisitorIface;

public class ForAST
extends StmtAST
implements BreakableStmtAST, ConditionalStmtAST
{

    public ForAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ForVisitorIface)
            return ((ForVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        String init = super.getChild(0) != null ? super.getChild(0).toString() : "";
        String cond = super.getChild(1) != null ? super.getChild(1).toString() : "";
        String inc = super.getChild(2) != null ? super.getChild(2).toString() : "";
        String stmt = super.getChild(3) != null ? super.getChild(3).toString() : "";
        return "for (" + init  + "; " + cond + "; " + inc + ")\n" + stmt;
    }

    @Override
    public String getConditionalStmt()
    {
        String init = super.getChild(0) != null ? super.getChild(0).toString() : "";
        String cond = super.getChild(1) != null ? super.getChild(1).toString() : "";
        String inc = super.getChild(2) != null ? super.getChild(2).toString() : "";
        return "for (" + init.trim()  + " " + cond + "; " + inc + ")";
    }
}

