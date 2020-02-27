package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
        return current.bitwiseAnd(next);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        BitwiseAndExpressionState copy = new BitwiseAndExpressionState(ctx, payload);
        return super.decorate(copy);
    }
}
