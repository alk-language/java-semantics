package execution.state.expression;

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
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        return current.logicalAnd(next);
    }
}