package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.BitwiseOrExpressionContext.class)
public class BitwiseOrExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.BitwiseOrExpressionContext ctx;

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, Payload payload) {
        super(tree, payload, tree.bitwise_and(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("|"))
            return current.bitwiseOr(next);
        return current.bitwiseXor(next);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        BitwiseOrExpressionState copy = new BitwiseOrExpressionState(ctx, payload);
        return super.decorate(copy);
    }
}