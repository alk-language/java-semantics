package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class ShiftExpressionState extends GuardedGeneratorState<AlkValue> {
    public ShiftExpressionState(alkParser.ShiftExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.additive_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("<<"))
            return current.shiftLeft(next);
        return next.shiftRight(next);
    }
}
