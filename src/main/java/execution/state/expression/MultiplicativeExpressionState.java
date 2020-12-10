package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.MultiplicativeExpressionContext.class)
public class MultiplicativeExpressionState extends GuardedGeneratorState<AlkValue> {

    alkParser.MultiplicativeExpressionContext ctx;

    public MultiplicativeExpressionState(alkParser.MultiplicativeExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.unary_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in multiplicative expression.");
        }

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
        MultiplicativeExpressionState copy = new MultiplicativeExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
