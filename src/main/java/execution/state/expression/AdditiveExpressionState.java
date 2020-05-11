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

@CtxState(ctxClass = alkParser.AdditiveExpressionContext.class)
public class AdditiveExpressionState extends GuardedGeneratorState<AlkValue>
{
    alkParser.AdditiveExpressionContext ctx;

    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, Payload payload) {
        super(tree, payload, tree.multiplicative_expression(), ExpressionVisitor.class);
        visitor = ExpressionVisitor.class;
        ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
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
        AdditiveExpressionState copy = new AdditiveExpressionState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
