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

@CtxState(ctxClass = alkParser.MultiplicativeExpressionContext.class)
public class MultiplicativeExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.MultiplicativeExpressionContext ctx;

    public MultiplicativeExpressionState(alkParser.MultiplicativeExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        try {
            switch (tree.getChild(getSignPos()).getText()) {
                case "*":
                    return current.multiply(next);
                case "/":
                    return current.divide(next);
                default:
                    return current.mod(next);
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
        MultiplicativeExpressionState copy = new MultiplicativeExpressionState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
