package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;


public class DeclAST
extends StmtAST
{
    public DeclAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return getChild(0) + (getChildCount() > 1 ? ":"  + getChild(1) : "");
    }
}
