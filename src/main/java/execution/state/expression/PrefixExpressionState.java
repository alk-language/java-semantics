package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class PrefixExpressionState extends SingleState {


    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.unary_expression());
    }

    @Override
    protected AlkValue interpretResult() {
        switch (tree.getChild(0).getText())
        {
            case "++":
                return localResult.plusplusleft();
            case "--":
                return localResult.minusminusleft();
            case "++%":
                return localResult.plusplusmod();
            default:
                return localResult.minusminusmod();
        }
    }
}
