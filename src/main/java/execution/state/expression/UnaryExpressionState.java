package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class UnaryExpressionState extends SingleState
{
    public UnaryExpressionState(alkParser.UnaryExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.unary_expression());
    }

    @Override
    protected AlkValue interpretResult() {
        switch (tree.getChild(0).getText())
        {
            case "*":
                return localResult.star();
            case "+":
                return localResult.positive();
            case "-":
                return localResult.negative();
            default:
                return localResult.not();
        }
    }
}
