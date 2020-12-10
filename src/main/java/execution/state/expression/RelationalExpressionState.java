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

@CtxState(ctxClass = alkParser.RelationalExpressionContext.class)
public class RelationalExpressionState extends GuardedGeneratorState<AlkValue>
{
    private alkParser.RelationalExpressionContext ctx;

    public RelationalExpressionState(alkParser.RelationalExpressionContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.set_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next)
    {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in relational expression.");
        }

        try
        {
            switch (tree.getChild(getSignPos()).getText()) {
                case "<=":
                    return current.lowereq(next);
                case "<":
                    return current.lower(next);
                case ">=":
                    return current.greatereq(next);
                default:
                    return current.greater(next);
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
        RelationalExpressionState copy = new RelationalExpressionState((alkParser.RelationalExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
