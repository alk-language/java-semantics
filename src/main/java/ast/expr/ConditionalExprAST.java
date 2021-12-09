package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ConditionalExprVisitorIface;

public class ConditionalExprAST
extends ExpressionAST
{
    public ConditionalExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST lft = ((ExpressionAST) getThenExpression()).getDataType(dtp);
        DataTypeAST rgh = ((ExpressionAST) getElseExpression()).getDataType(dtp);
        if (!lft.equals(rgh))
        {
            throw new AlkException("Conditional expression is invalid as branches have different data types.");
        }
        return lft;
    }

    @Override
    public String toString()
    {
        return getCondition().toString() + " ? " +
               getThenExpression().toString() + " : " + getElseExpression().toString();
    }

    public AST getCondition()
    {
        return super.getChild(0);
    }

    public AST getThenExpression()
    {
        return super.getChild(1);
    }

    public AST getElseExpression()
    {
        return super.getChild(2);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ConditionalExprVisitorIface)
            return ((ConditionalExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
