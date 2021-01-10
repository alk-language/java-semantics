package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.BitwiseAndVisitorIface;

import java.util.List;

public class BitwiseAndAST
extends AST
{
    public BitwiseAndAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static BitwiseAndAST createBinary(Operator op, List<AST> children)
    {
        BitwiseAndAST ast = new BitwiseAndAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BitwiseAndVisitorIface)
            return ((BitwiseAndVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
