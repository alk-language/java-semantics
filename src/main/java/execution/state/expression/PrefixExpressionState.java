package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.PrefixExpressionContext.class)
public class PrefixExpressionState extends SingleState<Value, Value> {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
    }

    @Override
    protected Value interpretResult(Value value) {
        try {
            Value result = value;

            switch (tree.getChild(0).getText())
            {
                case "++":
                    result = ((AlkValue) result.toRValue()).plusplusleft(); break;
                case "--":
                    result = ((AlkValue) result.toRValue()).minusminusleft(); break;
                case "++%":
                    result = ((AlkValue) result.toRValue()).plusplusmod(); break;
                case "--%":
                    result = ((AlkValue) result.toRValue()).minusminusmod(); break;
                default:
                    throw new InternalException("Unknown prefix operator used.");
            }

            return result;
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        PrefixExpressionState copy = new PrefixExpressionState((alkParser.PrefixExpressionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
