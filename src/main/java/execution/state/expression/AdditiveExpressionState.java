package execution.state.expression;

import execution.Execution;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.AdditiveExpressionContext.class)
public class AdditiveExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.AdditiveExpressionContext ctx;

    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, Payload payload) {
        super(tree, payload, tree.multiplicative_expression(), ExpressionVisitor.class);
        visitor = ExpressionVisitor.class;
        ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("+"))
            return current.add(next);
        return current.subtract(next);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        AdditiveExpressionState copy = new AdditiveExpressionState(ctx, payload);
        return super.decorate(copy);
    }
}
