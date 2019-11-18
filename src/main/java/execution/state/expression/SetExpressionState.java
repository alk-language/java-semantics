package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class SetExpressionState extends GuardedGeneratorState<AlkValue> {

    public SetExpressionState(alkParser.SetExpressionContext ctx, ExpressionVisitor visitor) {
        super(ctx, visitor, ctx.bitwise_or());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "U":
                return current.union(next);
            case "^":
                return current.intersect(next);
            default:
                return current.setSubtract(next);
        }
    }
}