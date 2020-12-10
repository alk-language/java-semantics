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

@CtxState(ctxClass = alkParser.BitwiseOrExpressionContext.class)
public class BitwiseOrExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.BitwiseOrExpressionContext ctx;

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.bitwise_and(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in bitwise or expression.");
        }

        try{
            if (tree.getChild(getSignPos()).getText().equals("|"))
                return current.bitwiseor(next);
            return current.bitwisexor(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BitwiseOrExpressionState copy = new BitwiseOrExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}