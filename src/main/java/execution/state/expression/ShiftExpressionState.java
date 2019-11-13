package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class ShiftExpressionState extends GeneratorState {
    public ShiftExpressionState(alkParser.ShiftExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.additive_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        if (tree.getChild(getSignPos()).getText().equals("<<"))
            return localResult.shiftLeft(result.getValue());
        return localResult.shiftRight(result.getValue());
    }
}
