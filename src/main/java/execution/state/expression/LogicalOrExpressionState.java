package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

@CtxState(ctxClass = alkParser.LogicalOrExpressionContext.class)
public class LogicalOrExpressionState extends GuardedGeneratorState<Value>
{
    public LogicalOrExpressionState(alkParser.LogicalOrExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.logical_and_expression(), ExpressionVisitor.class);
        setPreValidator(() -> {
            if (getLocalResult() != null)
            {
                Value rVal = getLocalResult().toRValue();
                if (!(rVal instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALOR);

                return !((AlkBool) rVal).isTrue();
            }
            return true;
        });
    }

    @Override
    protected AlkValue interpretResult(Value current, Value next) {
        try
        {
            return ((AlkBool) current).logicalOr((AlkBool) next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }


    @Override
    public ExecutionState clone(SplitMapper sm) {
        LogicalOrExpressionState copy = new LogicalOrExpressionState((alkParser.LogicalOrExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}