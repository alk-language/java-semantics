package execution.state.expression;

import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.PrefixExpressionContext.class)
public class PrefixExpressionState extends SingleState<AlkValue, AlkValue> {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression(), ExpressionVisitor.class);
    }

    @Override
    protected AlkValue interpretResult(AlkValue value) {
        switch (tree.getChild(0).getText())
        {
            case "++":
                return value.plusplusleft();
            case "--":
                return value.minusminusleft();
            case "++%":
                return value.plusplusmod();
            default:
                return value.minusminusmod();
        }
    }
}
