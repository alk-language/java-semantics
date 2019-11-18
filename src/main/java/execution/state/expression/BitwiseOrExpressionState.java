package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class BitwiseOrExpressionState extends GuardedGeneratorState<AlkValue> {

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.bitwise_and());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("|"))
            return current.bitwiseOr(next);
        return current.bitwiseXor(next);
    }
}