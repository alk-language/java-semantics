package execution.state.expression;

import execution.Execution;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.VisitorFactory;
import util.types.Value;

import static parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

@CtxState(ctxClass = alkParser.ConditionalExpressionContext.class)
public class ConditionalExpressionState extends ExecutionState {

    private alkParser.ConditionalExpressionContext ctx;
    private Value queryExpression;

    public ConditionalExpressionState(alkParser.ConditionalExpressionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (result != null)
        {
            return null;
        }

        if (queryExpression == null)
        {
            return request(ExpressionVisitor.class, ctx.logical_or_expression());
        }

        if (ctx.expression().size() == 0)
        {
            result = new ExecutionResult<>(queryExpression);
            return null;
        }

        queryExpression = queryExpression.toRValue();
        if (!(queryExpression instanceof AlkBool))
        {
            throw new AlkException(ERR_CONDITIONAL_NO_BOOL);
        }

        if (((AlkBool) queryExpression).isTrue())
        {
            return request(ExpressionVisitor.class, ctx.expression(0));
        }
        else
        {
            return request(ExpressionVisitor.class, ctx.expression(1));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (queryExpression == null)
        {
            queryExpression = result.getValue();
        }
        else
        {
            this.result = new ExecutionResult(result.getValue().toRValue());
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ConditionalExpressionState copy = new ConditionalExpressionState(ctx, payload);
        copy.queryExpression = queryExpression.clone();
        return copy;
    }
}