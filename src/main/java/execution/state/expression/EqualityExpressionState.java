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

@CtxState(ctxClass = alkParser.EqualityExpressionContext.class)
public class EqualityExpressionState extends GuardedGeneratorState<AlkValue>
{

    private alkParser.EqualityExpressionContext ctx;

    public EqualityExpressionState(alkParser.EqualityExpressionContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.relational_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in equality expression.");
        }

        try {
            if (tree.getChild(getSignPos()).getText().equals("=="))
                return current.equal(next);
            return current.notequal(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EqualityExpressionState copy = new EqualityExpressionState((alkParser.EqualityExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}