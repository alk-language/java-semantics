package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class RelationalExpressionState extends GuardedGeneratorState<AlkValue>
{
    public RelationalExpressionState(alkParser.RelationalExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.set_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next)
    {
        switch (tree.getChild(getSignPos()).getText()) {
            case "<=":
                return current.lowereq(next);
            case "<":
                return current.lower(next);
            case ">=":
                return current.greatereq(next);
            default:
                return current.greater(next);
        }
    }
}
