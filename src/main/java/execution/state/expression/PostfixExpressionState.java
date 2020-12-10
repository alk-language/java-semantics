package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.PostfixExpressionContext.class)
public class PostfixExpressionState extends SingleState<Value, Value> {

    private alkParser.PostfixExpressionContext ctx;

    public PostfixExpressionState(alkParser.PostfixExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.factor(), ExpressionVisitor.class);
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
        PostfixExpressionState copy = new PostfixExpressionState((alkParser.PostfixExpressionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }

}
