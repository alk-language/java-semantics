package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.UnaryVisitorIface;

import java.util.Collections;
import java.util.List;

public class UnaryAST
extends ExpressionAST
{
    public UnaryAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static UnaryAST createUnary(Operator op, AST child)
    {
        return createUnary(op, Collections.singletonList(child));
    }

    public static UnaryAST createUnary(Operator op, List<AST> children)
    {
        UnaryAST ast = new UnaryAST(null);
        children.forEach(ast::addChild);
        ast.addOpsASTAttr(op);
        return ast;
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST chld = ((ExpressionAST) getChild(0)).getDataType(dtp);
        if (chld instanceof IntDataTypeAST   ||
            chld instanceof FloatDataTypeAST ||
            chld instanceof BoolDataTypeAST)
        {
            return chld;
        }

        throw new AlkException("Invalid data type for unary expression: " + chld);
    }

    @Override
    public String toString()
    {
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < attr.getOpCount(); i++)
        {
            sb.append(attr.getOp(i).getSyntax());
        }
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
