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

import static parser.exceptions.AlkException.ERR_LOGICALAND;
import static parser.exceptions.AlkException.ERR_LOGICALOR;

@CtxState(ctxClass = alkParser.LogicalAndExpressionContext.class)
public class LogicalAndExpressionState extends GuardedGeneratorState<Value>
{

    alkParser.LogicalAndExpressionContext ctx;

    public LogicalAndExpressionState(alkParser.LogicalAndExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.in_expression(), ExpressionVisitor.class);
        setPreValidator(() -> {
            if (getLocalResult() != null)
            {
                Value rVal = getLocalResult().toRValue();
                if (!(rVal instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALAND);

                return ((AlkBool) rVal).isTrue();
            }
            return true;
        });
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        LogicalAndExpressionState copy = new LogicalAndExpressionState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }

    @Override
    protected AlkValue interpretResult(Value current, Value next)
    {
        try
        {
            return ((AlkBool) current).logicalAnd((AlkBool) next);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

}