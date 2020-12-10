package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import static execution.parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

@CtxState(ctxClass = alkParser.ConditionalExpressionContext.class)
public class ConditionalExpressionState extends ExecutionState<Value, Value> {

    private alkParser.ConditionalExpressionContext ctx;
    private Value queryExpression;
    private boolean checkedQuery = false;

    public ConditionalExpressionState(alkParser.ConditionalExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (getResult() != null) {
            return null;
        }

        if (queryExpression == null && !checkedQuery) {
            return request(ExpressionVisitor.class, ctx.logical_or_expression());
        }

        if (ctx.expression().size() == 0) {
            setResult(new ExecutionResult<>(queryExpression));
            return null;
        }

        queryExpression = queryExpression.toRValue();
        if (!(queryExpression instanceof AlkBool)) {
            super.handle(new AlkException(ERR_CONDITIONAL_NO_BOOL));
        }

        if (((AlkBool) queryExpression).isTrue()) {
            return request(ExpressionVisitor.class, ctx.expression(0));
        }
        else {
            return request(ExpressionVisitor.class, ctx.expression(1));
        }
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        if (queryExpression == null) {
            checkedQuery = true;
            queryExpression = executionResult.getValue();
        }
        else
        {
            setResult(new ExecutionResult(executionResult.getValue().toRValue()));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ConditionalExpressionState copy = new ConditionalExpressionState(ctx, sm.getExecutionPayload());
        if (queryExpression != null)
        {
            copy.queryExpression = queryExpression.weakClone(sm.getLocationMapper());
        }
        return super.decorate(copy, sm);
    }
}