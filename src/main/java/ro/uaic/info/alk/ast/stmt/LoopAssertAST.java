package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;

public class LoopAssertAST
   extends AST
{
    public LoopAssertAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "@loopassert " + getChild(0) + System.lineSeparator();
    }
}
