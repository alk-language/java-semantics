package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.AdditiveExpressionContext.class)
public class AdditiveExpressionState extends GuardedGeneratorState<AlkValue> {
    public AdditiveExpressionState(alkParser.AdditiveExpressionContext tree, Payload payload) {
        super(tree, payload, tree.multiplicative_expression(), ExpressionVisitor.class);
        visitor = ExpressionVisitor.class;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("+"))
            return current.add(next);
        return current.subtract(next);
    }
}
