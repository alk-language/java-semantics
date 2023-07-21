package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.OperatorUtils;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.PostfixVisitorIface;

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
        children.forEach(ast::addChild);
        ast.addOpsASTAttr(op);
        return ast;
    }

    @Override
    public String toString()
    {
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        StringBuilder sb = new StringBuilder(super.getChild(0).toString());
        for (int i = 0; i <attr.getOpCount(); i++)
            sb.append(attr.getOp(i).getSyntax());
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
