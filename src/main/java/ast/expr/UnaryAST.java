package ast.expr;

import ast.AST;
import ast.attr.OpsASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.UnaryVisitorIface;

import java.util.List;

public class UnaryAST
extends ExpressionAST
{
    public UnaryAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static UnaryAST createUnary(Operator op, List<AST> children)
    {
        UnaryAST ast = new UnaryAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < attr.getOpCount(); i++)
            sb.append(attr.getOp(i));
        sb.append(super.getChild(0).toString());
        return sb.toString();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof UnaryVisitorIface)
            return ((UnaryVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
