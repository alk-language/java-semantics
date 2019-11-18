package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class AdditiveExpressionState extends GuardedGeneratorState<AlkValue> {
    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.multiplicative_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("+"))
            return current.add(next);
        return current.subtract(next);
    }
}
