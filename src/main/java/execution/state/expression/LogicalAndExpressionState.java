package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import static execution.parser.exceptions.AlkException.ERR_LOGICALAND;

@CtxState(ctxClass = alkParser.LogicalAndExpressionContext.class)
public class LogicalAndExpressionState extends GuardedGeneratorState<Value>
{

    alkParser.LogicalAndExpressionContext ctx;

    public LogicalAndExpressionState(alkParser.LogicalAndExpressionContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.in_expression(), ExpressionVisitor.class);
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
        LogicalAndExpressionState copy = new LogicalAndExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }

    @Override
    protected AlkValue interpretResult(Value current, Value next)
    {
        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in logical and expression.");
        }

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