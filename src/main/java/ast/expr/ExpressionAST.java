package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class ExpressionAST
extends AST
{
    public ExpressionAST(ParserRuleContext ctx)
    {
        super(ctx);
    }
}
