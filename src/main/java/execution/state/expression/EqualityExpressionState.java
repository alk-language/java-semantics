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

@CtxState(ctxClass = alkParser.EqualityExpressionContext.class)
public class EqualityExpressionState extends GuardedGeneratorState<AlkValue>
{

    public EqualityExpressionState(alkParser.EqualityExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.relational_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
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
        EqualityExpressionState copy = new EqualityExpressionState((alkParser.EqualityExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}