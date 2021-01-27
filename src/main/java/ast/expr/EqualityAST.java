package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.EqualityVisitorIface;

import java.util.List;

public class EqualityAST
extends ExpressionAST
{
    public static EqualityAST createBinary(Operator op, List<AST> children)
    {
        EqualityAST ast = new EqualityAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    public EqualityAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof EqualityVisitorIface)
            return ((EqualityVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
