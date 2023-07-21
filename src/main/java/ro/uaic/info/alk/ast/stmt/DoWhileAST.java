package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.DoWhileVisitorIface;

public class DoWhileAST
extends StmtAST
implements BreakableStmtAST, FinalTestConditionalStmtAST
{

    public DoWhileAST(ParserRuleContext ctx)
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
        if (visitor instanceof DoWhileVisitorIface)
            return ((DoWhileVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "do\n" + this.getStatement().toString() + "while (" + this.getCondition().toString() + ");\n";
    }

    @Override
    public String getDoRepeatStmt() {
        return "do";
    }

    @Override
    public String getConditionalStmt()
    {
        return "while " + getCondition().toString() + ";";
    }

}