package execution.state.expression;

import execution.Execution;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

@CtxState(ctxClass = alkParser.LogicalAndExpressionContext.class)
public class LogicalAndExpressionState extends GuardedGeneratorState<AlkValue>
{

    alkParser.LogicalAndExpressionContext ctx;

    public LogicalAndExpressionState(alkParser.LogicalAndExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.in_expression(), ExpressionVisitor.class);
        setPreValidator(() -> {
            if (getLocalResult() != null)
            {
                if (!(getLocalResult() instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALOR);

                return ((AlkBool) getLocalResult()).isTrue();
            }
            return true;
        });
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        LogicalAndExpressionState copy = new LogicalAndExpressionState(ctx, payload);
        return super.decorate(copy);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        return current.logicalAnd(next);
    }

}