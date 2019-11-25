package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

public class LogicalAndExpressionState extends GuardedGeneratorState<AlkValue>
{

    public LogicalAndExpressionState(alkParser.LogicalAndExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.in_expression());
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