package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;

public class LoopAssertAST
extends AST
{
    public LoopAssertAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "@loopassert " + this.getChild(0);
    }
}
