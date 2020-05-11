package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.UnaryExpressionContext.class)
public class UnaryExpressionState extends SingleState<Value, Value>
{
    public UnaryExpressionState(alkParser.UnaryExpressionContext tree, Payload payload)
    {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
        this.visitor = ExpressionVisitor.class;
    }

    @Override
    protected Value interpretResult(Value value) {
        try
        {
            AlkValue alkValue = (AlkValue) value.toRValue();
            switch (tree.getChild(0).getText())
            {
                case "*":
                    return alkValue.star();
                case "+":
                    return alkValue.positive();
                case "-":
                    return alkValue.negative();
                default:
                    return alkValue.not();
            }
        }
        catch(AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        UnaryExpressionState copy = new UnaryExpressionState((alkParser.UnaryExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }

}
