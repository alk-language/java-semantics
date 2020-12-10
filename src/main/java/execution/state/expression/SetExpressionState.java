package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.SetExpressionContext.class)
public class SetExpressionState extends GuardedGeneratorState<AlkValue> {

    private alkParser.SetExpressionContext ctx;

    public SetExpressionState(alkParser.SetExpressionContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, ctx.bitwise_or(), ExpressionVisitor.class);
        this.ctx = ctx;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {

        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in set expression.");
        }

        try {
            switch (tree.getChild(getSignPos()).getText()) {
                case "U":
                    return current.union(next, generator);
                case "^":
                    return current.intersect(next, generator);
                case "\\":
                    return current.setsubtract(next, generator);
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
        SetExpressionState copy = new SetExpressionState((alkParser.SetExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}