package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class MultiplicativeExpressionState extends GeneratorState {
    public MultiplicativeExpressionState(alkParser.MultiplicativeExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.unary_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "*":
                return localResult.multiply(result.getValue());
            case "/":
                return localResult.divide(result.getValue());
            default:
                return localResult.mod(result.getValue());
        }
    }
}
