package execution.state.expression;

import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class PrefixExpressionState extends SingleState<AlkValue, AlkValue> {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.unary_expression());
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
