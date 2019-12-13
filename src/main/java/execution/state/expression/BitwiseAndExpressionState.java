package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.BitwiseAndExpressionContext.class)
public class BitwiseAndExpressionState extends GuardedGeneratorState<AlkValue> {
    public BitwiseAndExpressionState(alkParser.BitwiseAndExpressionContext tree, Payload payload) {
        super(tree, payload, tree.shift_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        return current.bitwiseAnd(next);
    }
}
