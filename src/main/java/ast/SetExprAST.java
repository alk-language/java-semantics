package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.SetExprVisitorIface;

import java.util.List;

public class SetExprAST
extends AST
{
    public SetExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static SetExprAST createBinary(Operator op, List<AST> children)
    {
        SetExprAST ast = new SetExprAST(null);
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
        if (visitor instanceof SetExprVisitorIface)
            return ((SetExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
