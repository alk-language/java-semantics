package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.AssertVisitorIface;

public class AssertAST
extends StmtAST
{
    public AssertAST(ASTContext ctx, AST target)
    {
        super(ctx);
        addChild(target);
    }

    public AST getTarget()
    {
        return getChild(0);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AssertVisitorIface)
            return ((AssertVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "@assert " + getTarget() + ";" + System.lineSeparator();
    }
}
