package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.AlkValue;
import grammar.alkParser;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.PostfixExpressionContext.class)
public class PostfixExpressionState extends SingleState<Value, Value> {

    private alkParser.PostfixExpressionContext ctx;

    public PostfixExpressionState(alkParser.PostfixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.factor(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected Value interpretResult(Value value) {

        try {
            Value result = value;

            if (tree.getChildCount() > 1 && result.toRValue() == null)
            {
                throw new AlkException(ctx.start.getLine(), "Undefined variable used in postfix expression.");
            }

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
