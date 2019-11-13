package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class AdditiveExpressionState extends GeneratorState {
    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.multiplicative_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        if (tree.getChild(getSignPos()).getText().equals("+"))
            return localResult.add(result.getValue());
        return localResult.subtract(result.getValue());
    }
}
