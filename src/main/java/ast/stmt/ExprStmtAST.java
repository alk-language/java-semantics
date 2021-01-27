package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.ExprStmtVisitorIface;

public class ExprStmtAST
extends StmtAST
{

    public ExprStmtAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ExprStmtVisitorIface)
            return ((ExprStmtVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return super.getChild(0).toString() + ";\n";
    }
}