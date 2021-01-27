package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.MultiplicativeVisitorIface;

import java.util.List;

public class MultiplicativeAST
extends ExpressionAST
{
    public MultiplicativeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static MultiplicativeAST createBinary(Operator op, List<AST> children)
    {
        MultiplicativeAST ast = new MultiplicativeAST(null);
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
        if (visitor instanceof MultiplicativeVisitorIface)
            return ((MultiplicativeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
