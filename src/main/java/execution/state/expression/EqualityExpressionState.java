package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;

public class EqualityExpressionState extends GuardedGeneratorState<AlkValue>
{

    public EqualityExpressionState(alkParser.EqualityExpressionContext tree, ExpressionVisitor visitor)
    {
        super(tree, visitor, tree.relational_expression());
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("=="))
            return current.equal(next);
        return current.notequal(next);
    }
}