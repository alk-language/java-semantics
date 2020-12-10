package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.PrefixExpressionContext.class)
public class PrefixExpressionState extends SingleState<Value, Value> {

    private alkParser.PrefixExpressionContext ctx;

    public PrefixExpressionState(alkParser.PrefixExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.unary_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    protected Value interpretResult(Value value) {
        try {
            Value result = value;

            if (result.toRValue() == null)
            {
                throw new AlkException(ctx.start.getLine(), "Undefined variable used in prefix expression.");
            }

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
        PrefixExpressionState copy = new PrefixExpressionState((alkParser.PrefixExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
