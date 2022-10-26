package ast.expr;

import ast.AST;
import ast.OperatorUtils;
import ast.attr.OpsASTAttr;
import ast.type.*;
import execution.parser.exceptions.AlkException;
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

    public static UnaryAST createUnary(Operator op, AST child)
    {
        UnaryAST ast = new UnaryAST(null);
        ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    public static UnaryAST createUnary(Operator op, List<AST> children)
    {
        UnaryAST ast = new UnaryAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST chld = ((ExpressionAST) getChild(0)).getDataType(dtp);
        if (chld instanceof IntDataTypeAST || chld instanceof FloatDataTypeAST || chld instanceof BoolDataTypeAST)
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
            sb.append(OperatorUtils.toString(attr.getOp(i)));
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
