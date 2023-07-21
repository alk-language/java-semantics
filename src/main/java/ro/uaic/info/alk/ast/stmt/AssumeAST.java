package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.AssumeVisitorIface;

public class AssumeAST
extends StmtAST
{
    public AssumeAST(ASTContext ctx, AST target)
    {
        super(ctx);
        addChild(target);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AssumeVisitorIface)
            return ((AssumeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    public AST getTarget()
    {
        return getChild(0);
    }

    @Override
    public String toString()
    {
        return "@assume " + getTarget() + ";" + System.lineSeparator();
    }
}