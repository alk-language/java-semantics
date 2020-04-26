package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.AlkValue;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.PostfixExpressionContext.class)
public class PostfixExpressionState extends SingleState<Value, Value> {

    public PostfixExpressionState(alkParser.PostfixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.factor(), ExpressionVisitor.class);
    }

    @Override
    protected Value interpretResult(Value value) {
        Value result = value;

        for (int i=1; i<tree.getChildCount(); i++)
        {
            switch (tree.getChild(i).getText()) {
                case "++":
                    result = ((AlkValue) result.toRValue()).plusplusright();
                    break;
                case "--":
                    result = ((AlkValue) result.toRValue()).minusminusright();
                    break;
                default:
                    throw new InternalException("Unknown postfix operator used.");
            }
        }

        return result;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        PrefixExpressionState copy = new PrefixExpressionState((alkParser.PrefixExpressionContext) tree, payload);
        return super.decorate(copy);
    }

}
