package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class InExpressionState extends GuardedGeneratorState<AlkValue> {

    public InExpressionState(alkParser.InExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.equality_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        return current.in(next);
    }

}