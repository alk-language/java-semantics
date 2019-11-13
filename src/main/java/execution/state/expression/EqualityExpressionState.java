package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class EqualityExpressionState extends GeneratorState
{

    public EqualityExpressionState(alkParser.EqualityExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.relational_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        if (tree.getChild(getSignPos()).getText().equals("=="))
            return localResult.equal(result.getValue());
        return localResult.notequal(result.getValue());
    }
}