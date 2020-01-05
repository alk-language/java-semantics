package execution.state.expression;

import execution.Execution;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.SetExpressionContext.class)
public class SetExpressionState extends GuardedGeneratorState<AlkValue> {

    public SetExpressionState(alkParser.SetExpressionContext ctx, Payload payload) {
        super(ctx, payload, ctx.bitwise_or(), ExpressionVisitor.class);
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

    @Override
    public ExecutionState clone(Payload payload) {
        RelationalExpressionState copy = new RelationalExpressionState((alkParser.RelationalExpressionContext) tree, payload);
        return super.decorate(copy);
    }
}