package execution.state.expression;

import execution.state.GuardedGeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.RelationalExpressionContext.class)
public class RelationalExpressionState extends GuardedGeneratorState<AlkValue>
{
    public RelationalExpressionState(alkParser.RelationalExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.set_expression(), ExpressionVisitor.class);
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
