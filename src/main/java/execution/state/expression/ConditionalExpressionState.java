package execution.state.expression;

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

import static parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

@CtxState(ctxClass = alkParser.ConditionalExpressionContext.class)
public class ConditionalExpressionState extends ExecutionState {

    private alkParser.ConditionalExpressionContext ctx;
    private AlkValue queryExpression;

    public ConditionalExpressionState(alkParser.ConditionalExpressionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        alkBaseVisitor visitor = VisitorFactory.create(ExpressionVisitor.class, getEnv(), payload);

        if (result != null)
        {
            return null;
        }

        if (queryExpression == null)
        {
            return (ExecutionState) visitor.visit(ctx.logical_or_expression());
        }

        if (ctx.expression().size() == 0)
        {
            result = new ExecutionResult<>(queryExpression);
            return null;
        }

        if (!(queryExpression instanceof AlkBool))
        {
            throw new AlkException(ERR_CONDITIONAL_NO_BOOL);
        }

        if (((AlkBool) queryExpression).isTrue())
        {
            return (ExecutionState) visitor.visit(ctx.expression(0));
        }
        else
        {
            return (ExecutionState) visitor.visit(ctx.expression(1));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (queryExpression == null)
        {
            queryExpression = (AlkValue) result.getValue();
        }
        else
        {
            this.result = result;
        }
    }
}