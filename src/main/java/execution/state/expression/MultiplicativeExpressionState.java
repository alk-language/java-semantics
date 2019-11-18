package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class MultiplicativeExpressionState extends GuardedGeneratorState<AlkValue> {
    public MultiplicativeExpressionState(alkParser.MultiplicativeExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.unary_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "*":
                return current.multiply(next);
            case "/":
                return current.divide(next);
            default:
                return current.mod(next);
        }
    }
}
