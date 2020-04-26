package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.SetExpressionContext.class)
public class SetExpressionState extends GuardedGeneratorState<AlkValue> {

    public SetExpressionState(alkParser.SetExpressionContext ctx, Payload payload) {
        super(ctx, payload, ctx.bitwise_or(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "U":
                return current.union(next, generator);
            case "^":
                return current.intersect(next, generator);
            case "\\":
                return current.setSubtract(next, generator);
            default:
                throw new InternalException("Undefined set operator");
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        RelationalExpressionState copy = new RelationalExpressionState((alkParser.RelationalExpressionContext) tree, payload);
        return super.decorate(copy);
    }
}