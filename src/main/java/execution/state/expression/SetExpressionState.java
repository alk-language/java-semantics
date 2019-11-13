package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class SetExpressionState extends GeneratorState {

    public SetExpressionState(alkParser.SetExpressionContext ctx, ExpressionVisitor visitor) {
        super(ctx, visitor, ctx.bitwise_or());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "U":
                return localResult.union(result.getValue());
            case "^":
                return localResult.intersect(result.getValue());
            default:
                return localResult.setSubtract(result.getValue());
        }
    }
}