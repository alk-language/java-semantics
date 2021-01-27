package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.RepeatUntilVisitorIface;

public class RepeatUntilAST
extends StmtAST
{

    public RepeatUntilAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getStatement()
    {
        return super.getChild(0);
    }

    public AST getCondition()
    {
        return super.getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof RepeatUntilVisitorIface)
            return ((RepeatUntilVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "repeat\n" + this.getStatement().toString() + "until (" + this.getCondition().toString() + ");\n";
    }
}