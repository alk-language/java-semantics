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

@CtxState(ctxClass = alkParser.ShiftExpressionContext.class)
public class ShiftExpressionState extends GuardedGeneratorState<AlkValue> {
    public ShiftExpressionState(alkParser.ShiftExpressionContext tree, Payload payload) {
        super(tree, payload, tree.additive_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        try
        {
            if (tree.getChild(getSignPos()).getText().equals("<<"))
                return current.shiftLeft(next);
            return next.shiftRight(next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }


    @Override
    public ExecutionState clone(SplitMapper sm) {
        ShiftExpressionState copy = new ShiftExpressionState((alkParser.ShiftExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
