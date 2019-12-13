package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.BitwiseOrExpressionContext.class)
public class BitwiseOrExpressionState extends GuardedGeneratorState<AlkValue> {

    public BitwiseOrExpressionState(alkParser.BitwiseOrExpressionContext tree, Payload payload) {
        super(tree, payload, tree.bitwise_and(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("|"))
            return current.bitwiseOr(next);
        return current.bitwiseXor(next);
    }
}