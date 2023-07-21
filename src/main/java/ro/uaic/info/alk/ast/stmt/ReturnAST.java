package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.ReturnStmtVisitorIface;

public class ReturnAST
extends StmtAST
implements BreakableStmtAST
{

    public ReturnAST(ASTContext ctx, AST target)
    {
        super(ctx);
        if (target != null)
        {
            addChild(target);
        }
    }

    public AST getTarget()
    {
        return getChild(0);
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
        return "return" + (getTarget() != null ? " " + getTarget() : "") + ";" + System.lineSeparator();
    }
}
