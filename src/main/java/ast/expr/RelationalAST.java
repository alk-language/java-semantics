package ast.expr;

import ast.AST;
import ast.enums.Operator;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.RelationalVisitorIface;

import java.util.List;

public class RelationalAST
extends ExpressionAST
{
    public RelationalAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static AST createBinary(Operator op, List<AST> children)
    {
        RelationalAST ast = new RelationalAST(null);
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
        if (visitor instanceof RelationalVisitorIface)
            return ((RelationalVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
