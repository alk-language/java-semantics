package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

public class LogicalAndExpressionState extends GeneratorState
{

    public LogicalAndExpressionState(alkParser.LogicalAndExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.in_expression());
        setPreValidator(() -> {
            if (localResult != null)
            {
                if (!(localResult instanceof AlkBool))
                    throw new AlkException(ERR_LOGICALOR);

                if (!((AlkBool)localResult).isTrue())
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
        return localResult.logicalAnd(result.getValue());
    }
}