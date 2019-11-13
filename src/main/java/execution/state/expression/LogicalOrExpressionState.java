package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GeneratorState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

public class LogicalOrExpressionState extends GeneratorState
{

    public LogicalOrExpressionState(alkParser.LogicalOrExpressionContext tree, alkBaseVisitor visitor)
    {
        super(tree, visitor, tree.logical_and_expression());
        setPreValidator(() -> {
            if (localResult != null)
            {
                if (!(localResult instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALOR);

                if (((AlkBool)localResult).isTrue())
                {
                    result = new ExecutionResult(localResult);
                    return false;
                }
            }
            return true;
        });
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        return localResult.logicalOr(result.getValue());
    }
}