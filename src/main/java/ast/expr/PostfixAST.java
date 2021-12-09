package ast.expr;

import ast.AST;
import ast.OperatorUtils;
import ast.attr.OpsASTAttr;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.PostfixVisitorIface;

import java.util.List;

public class PostfixAST
extends ExpressionAST
{
    public PostfixAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return ((ExpressionAST) getChild(0)).getDataType(dtp);
    }

    public static PostfixAST createUnary(Operator op, List<AST> children)
    {
        PostfixAST ast = new PostfixAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        StringBuilder sb = new StringBuilder(super.getChild(0).toString());
        for (int i = 0; i <attr.getOpCount(); i++)
            sb.append(OperatorUtils.toString(attr.getOp(i)));
        return sb.toString();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof PostfixVisitorIface)
            return ((PostfixVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
