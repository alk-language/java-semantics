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

@CtxState(ctxClass = alkParser.BitwiseAndExpressionContext.class)
public class BitwiseAndExpressionState extends GuardedGeneratorState<AlkValue>
{
    alkParser.BitwiseAndExpressionContext ctx;

    public BitwiseAndExpressionState(alkParser.BitwiseAndExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.shift_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        try
        {
            return current.bitwiseAnd(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BitwiseAndExpressionState copy = new BitwiseAndExpressionState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
