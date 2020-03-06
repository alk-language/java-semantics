package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

@CtxState(ctxClass = alkParser.PrefixExpressionContext.class)
public class PrefixExpressionState extends SingleState<Value, Value> {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
    }

    @Override
    protected Value interpretResult(Value value) {
        AlkValue alkValue = (AlkValue) value.toRValue();
        AlkValue result;
        switch (tree.getChild(0).getText())
        {
            case "++":
                result = alkValue.plusplusleft(); break;
            case "--":
                result = alkValue.minusminusleft(); break;
            case "++%":
                result = alkValue.plusplusmod(); break;
            default:
                result = alkValue.minusminusmod(); break;
        }

        try {
            Location loc = value.toLValue();
            loc.assign(alkValue);
        }
        // TODO: don't ignore
        catch (AlkException ignored){}

        return result;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        PrefixExpressionState copy = new PrefixExpressionState((alkParser.PrefixExpressionContext) tree, payload);
        return super.decorate(copy);
    }
}
