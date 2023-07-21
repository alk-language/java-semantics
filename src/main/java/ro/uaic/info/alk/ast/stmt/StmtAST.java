package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.ASTContext;

public abstract class StmtAST
extends AST
{
    public StmtAST(ASTContext ctx)
    {
        super(ctx);
    }
}
