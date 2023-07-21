package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.IfThenVisitorIface;

public class IfThenAST
extends StmtAST
implements BreakableStmtAST,
           ConditionalStmtAST
{
    public IfThenAST(ASTContext ctx)
    {
        super(ctx);
    }

    public AST getCondition()
    {
        return getChild(0);
    }

    public AST getThenBranch()
    {
        return getChild(1);
    }

    public AST getElseBranch()
    {
        if (!hasElseBranch())
        {
            return null;
        }
        return getChild(2);
    }

    public boolean hasElseBranch()
    {
        return getChildCount() == 3;
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
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(getCondition()).append(")").append(System.lineSeparator());
        sb.append(getThenBranch());
        if (hasElseBranch())
        {
            sb.append("else").append(System.lineSeparator()).append(getElseBranch());
        }
        return sb.toString();
    }

    @Override
    public String getConditionalStmt()
    {
        return "if (" + getCondition() + ")";
    }
}