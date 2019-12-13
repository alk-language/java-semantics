package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

@CtxState(ctxClass = alkParser.UnaryExpressionContext.class)
public class UnaryExpressionState extends SingleState<AlkValue, AlkValue>
{
    public UnaryExpressionState(alkParser.UnaryExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
        this.visitor = ExpressionVisitor.class;
    }

    @Override
    protected AlkValue interpretResult(AlkValue value) {
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
