package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class BitwiseOrExpressionState extends GeneratorState {

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.bitwise_and());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        if (tree.getChild(getSignPos()).getText().equals("|"))
            return localResult.bitwiseOr(result.getValue());
        return localResult.bitwiseXor(result.getValue());
    }
}