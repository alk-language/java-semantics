package execution.state.expression;

import execution.Execution;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.MultiplicativeExpressionContext.class)
public class MultiplicativeExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.MultiplicativeExpressionContext ctx;

    public MultiplicativeExpressionState(alkParser.MultiplicativeExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        switch (tree.getChild(getSignPos()).getText()) {
            case "*":
                return current.multiply(next);
            case "/":
                return current.divide(next);
            default:
                return current.mod(next);
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        MultiplicativeExpressionState copy = new MultiplicativeExpressionState(ctx, payload);
        return super.decorate(copy);
    }
}
