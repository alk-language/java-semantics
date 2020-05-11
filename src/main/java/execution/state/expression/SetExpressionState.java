package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.SetExpressionContext.class)
public class SetExpressionState extends GuardedGeneratorState<AlkValue> {

    public SetExpressionState(alkParser.SetExpressionContext ctx, Payload payload) {
        super(ctx, payload, ctx.bitwise_or(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        try {
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
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        RelationalExpressionState copy = new RelationalExpressionState((alkParser.RelationalExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}