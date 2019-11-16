package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

public class LogicalOrExpressionState extends GuardedGeneratorState<AlkValue>
{

    public LogicalOrExpressionState(alkParser.LogicalOrExpressionContext tree, alkBaseVisitor visitor)
    {
        super(tree, visitor, tree.logical_and_expression());
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
}