package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.IfThenVisitorIface;

public class IfThenAST
extends StmtAST
implements BreakableStmtAST, ConditionalStmtAST
{

    public IfThenAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getCondition()
    {
        return super.getChild(0);
    }

    public AST getThenBranch()
    {
        return super.getChild(1);
    }

    public AST getElseBranch()
    {
        if (!hasElseBranch())
        {
            return null;
        }
        return super.getChild(2);
    }

    public boolean hasElseBranch()
    {
        return super.getChildCount() == 3;
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof IfThenVisitorIface)
            return ((IfThenVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        String s = "if (" + this.getCondition().toString() + ")\n" + this.getThenBranch().toString();
        if (hasElseBranch())
        {
            s += "else\n" + this.getElseBranch();
        }
        return s;
    }

    @Override
    public String getConditionalStmt()
    {
        return "if (" + this.getCondition().toString() + ")";
    }
}