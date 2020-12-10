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

import static execution.parser.exceptions.AlkException.ERR_LOGICALOR;

@CtxState(ctxClass = alkParser.LogicalOrExpressionContext.class)
public class LogicalOrExpressionState extends GuardedGeneratorState<Value>
{
    private alkParser.LogicalOrExpressionContext ctx;

    public LogicalOrExpressionState(alkParser.LogicalOrExpressionContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.logical_and_expression(), ExpressionVisitor.class);
        this.ctx = tree;
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

        if (current == null || next == null)
        {
            throw new AlkException(ctx.start.getLine(), "Undefined variable used in logical or expression.");
        }

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
        LogicalOrExpressionState copy = new LogicalOrExpressionState((alkParser.LogicalOrExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}