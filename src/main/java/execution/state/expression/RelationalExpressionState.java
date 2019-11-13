package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.InterpretorException;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class RelationalExpressionState extends GeneratorState
{
    public RelationalExpressionState(alkParser.RelationalExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.set_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result)
    {
        switch (tree.getChild(getSignPos()).getText()) {
            case "<=":
                return localResult.lowereq(result.getValue());
            case "<":
                return localResult.lower(result.getValue());
            case ">=":
                return localResult.greatereq(result.getValue());
            default:
                return localResult.greater(result.getValue());
        }
    }
}
