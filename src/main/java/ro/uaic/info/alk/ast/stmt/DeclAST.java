package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;


public class DeclAST
extends StmtAST
{
    public DeclAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return getAttribute(IdASTAttr.class).getId() + " : " + getChild(0);
    }
}
