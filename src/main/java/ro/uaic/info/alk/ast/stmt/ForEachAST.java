package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.ForEachVisitorIface;

public class ForEachAST
extends StmtAST
implements BreakableStmtAST,
           ConditionalStmtAST
{

    public ForEachAST(ASTContext ctx)
    {
        super(ctx);
    }

    public AST getSource()
    {
        return getChild(0);
    }

    public AST getBody()
    {
        return getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ForEachVisitorIface)
            return ((ForEachVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr attr = getAttribute(IdASTAttr.class);
        return "foreach " + attr.getId() + " from " + getSource() + System.lineSeparator() + getBody();
    }

    @Override
    public String getConditionalStmt()
    {
        IdASTAttr attr = super.getAttribute(IdASTAttr.class);
        return "for each " + attr.getId() + " from " + getSource();
    }
}
