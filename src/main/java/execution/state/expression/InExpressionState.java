package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;

import static parser.exceptions.AlkException.ERR_LOGICALOR;

public class InExpressionState extends GeneratorState {

    public InExpressionState(alkParser.InExpressionContext tree, ExpressionVisitor visitor) {
        super(tree, visitor, tree.equality_expression());
    }

    @Override
    protected AlkValue interpretResult(ExecutionResult result) {
        return localResult.in(result.getValue());
    }

}