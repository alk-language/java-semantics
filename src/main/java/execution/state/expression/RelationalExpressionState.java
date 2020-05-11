package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.RelationalExpressionContext.class)
public class RelationalExpressionState extends GuardedGeneratorState<AlkValue>
{
    public RelationalExpressionState(alkParser.RelationalExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.set_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next)
    {
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
        RelationalExpressionState copy = new RelationalExpressionState((alkParser.RelationalExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
