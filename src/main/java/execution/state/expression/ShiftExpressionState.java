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

@CtxState(ctxClass = alkParser.ShiftExpressionContext.class)
public class ShiftExpressionState extends GuardedGeneratorState<AlkValue> {

    private alkParser.ShiftExpressionContext ctx;

    public ShiftExpressionState(alkParser.ShiftExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.additive_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {

        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in shift expression.");
        }

        try
        {
            if (tree.getChild(getSignPos()).getText().equals("<<"))
                return current.shiftleft(next);
            return current.shiftright(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }


    @Override
    public ExecutionState clone(SplitMapper sm) {
        ShiftExpressionState copy = new ShiftExpressionState((alkParser.ShiftExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
