package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.RepeatUntilVisitorIface;

public class RepeatUntilAST
extends StmtAST
implements BreakableStmtAST, FinalTestConditionalStmtAST
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

    @Override
    public String getDoRepeatStmt() {
        return "repeat";
    }

    @Override
    public String getConditionalStmt()
    {
        return "until " + this.getCondition().toString() + ";";
    }
}