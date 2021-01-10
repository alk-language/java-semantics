package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.InExprVisitorIface;

import java.util.List;

public class InExprAST
extends AST
{
    public InExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static InExprAST createBinary(Operator op, List<AST> children)
    {
        InExprAST ast = new InExprAST(null);
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
        if (visitor instanceof InExprVisitorIface)
            return ((InExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
