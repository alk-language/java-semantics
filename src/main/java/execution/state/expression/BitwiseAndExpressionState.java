package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class BitwiseAndExpressionState extends GeneratorState {
    public BitwiseAndExpressionState(alkParser.BitwiseAndExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.shift_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        return localResult.bitwiseAnd(result.getValue());
    }
}
