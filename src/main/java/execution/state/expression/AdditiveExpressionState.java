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

@CtxState(ctxClass = alkParser.AdditiveExpressionContext.class)
public class AdditiveExpressionState extends GuardedGeneratorState<AlkValue>
{
    alkParser.AdditiveExpressionContext ctx;

    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.multiplicative_expression(), ExpressionVisitor.class);
        visitor = ExpressionVisitor.class;
        ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in additive expression.");
        }

        try
        {
            if (tree.getChild(getSignPos()).getText().equals("+"))
                return current.add(next);
            return current.subtract(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        AdditiveExpressionState copy = new AdditiveExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
