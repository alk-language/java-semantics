package execution.state.expression;

import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.Payload;

public class PrefixExpressionState extends SingleState<AlkValue, AlkValue> {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.unary_expression());
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
