package execution.state.expression;

import execution.ExecutionResult;
import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.EqualityExpressionContext.class)
public class EqualityExpressionState extends GuardedGeneratorState<AlkValue>
{

    public EqualityExpressionState(alkParser.EqualityExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.relational_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue current, AlkValue next) {
        if (tree.getChild(getSignPos()).getText().equals("=="))
            return current.equal(next);
        return current.notequal(next);
    }
}