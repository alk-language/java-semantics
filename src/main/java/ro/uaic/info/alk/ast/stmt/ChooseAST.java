package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.ChooseVisitorIface;

public class ChooseAST
extends StmtAST
implements BreakableStmtAST
{
    public ChooseAST(ASTContext ctx)
    {
        super(ctx);
    }

    public AST getTarget()
    {
        return getChild(0);
    }

    public AST getSource()
    {
        return getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ChooseVisitorIface)
            return ((ChooseVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "choose " + getTarget() + " from " + getSource() +  ";" + System.lineSeparator();
    }
}
