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

@CtxState(ctxClass = alkParser.BitwiseOrExpressionContext.class)
public class BitwiseOrExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.BitwiseOrExpressionContext ctx;

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, Payload payload) {
        super(tree, payload, tree.bitwise_and(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        try{
            if (tree.getChild(getSignPos()).getText().equals("|"))
                return current.bitwiseOr(next);
            return current.bitwiseXor(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BitwiseOrExpressionState copy = new BitwiseOrExpressionState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}