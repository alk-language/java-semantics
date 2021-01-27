package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.WhileVisitorIface;

public class WhileAST
extends StmtAST
{

    public WhileAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getCondition()
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
        if (visitor instanceof WhileVisitorIface)
            return ((WhileVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "while (" + this.getCondition().toString() + ")\n" + this.getStatement().toString();
    }
}