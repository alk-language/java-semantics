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

@CtxState(ctxClass = alkParser.BitwiseAndExpressionContext.class)
public class BitwiseAndExpressionState extends GuardedGeneratorState<AlkValue>
{
    alkParser.BitwiseAndExpressionContext ctx;

    public BitwiseAndExpressionState(alkParser.BitwiseAndExpressionContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.shift_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in bitwise and expression.");
        }

        try
        {
            return current.bitwiseand(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BitwiseAndExpressionState copy = new BitwiseAndExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
