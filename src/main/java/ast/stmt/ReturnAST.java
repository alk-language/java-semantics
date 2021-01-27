package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.ReturnStmtVisitorIface;

public class ReturnAST
extends StmtAST
{

    public ReturnAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ReturnStmtVisitorIface)
            return ((ReturnStmtVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        String expr = super.getChildCount() > 0 ? super.getChild(0).toString() : "";
        return "return " + expr + ";";
    }
}
