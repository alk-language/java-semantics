package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

@CtxState(ctxClass = alkParser.LogicalOrExpressionContext.class)
public class LogicalOrExpressionState extends GuardedGeneratorState<AlkValue>
{
    public LogicalOrExpressionState(alkParser.LogicalOrExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.logical_and_expression(), ExpressionVisitor.class);
        setPreValidator(() -> {
            if (getLocalResult() != null)
            {
                if (!(getLocalResult() instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALOR);

                return !((AlkBool) getLocalResult()).isTrue();
            }
            return true;
        });
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        return current.logicalOr(next);
    }


    @Override
    public ExecutionState clone(Payload payload) {
        LogicalOrExpressionState copy = new LogicalOrExpressionState((alkParser.LogicalOrExpressionContext) tree, payload);
        return super.decorate(copy);
    }
}