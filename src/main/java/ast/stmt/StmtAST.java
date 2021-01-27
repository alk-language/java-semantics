package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class StmtAST
extends AST
{
    public StmtAST(ParserRuleContext ctx)
    {
        super(ctx);
    }
}
