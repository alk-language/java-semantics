package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
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

    @Override
    public ExecutionState clone(Payload payload) {
        UnaryExpressionState copy = new UnaryExpressionState((alkParser.UnaryExpressionContext) tree, payload);
        return super.decorate(copy);
    }

}
