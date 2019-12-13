package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ShiftExpressionContext.class)
public class ShiftExpressionState extends GuardedGeneratorState<AlkValue> {
    public ShiftExpressionState(alkParser.ShiftExpressionContext tree, Payload payload) {
        super(tree, payload, tree.additive_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("<<"))
            return current.shiftLeft(next);
        return next.shiftRight(next);
    }
}
