package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.visitors.expression.ExpressionVisitor;
import execution.parser.visitors.function.FunctionCallVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.MethodCallContext.class)
public class MethodCallState extends ExecutionState<Value, Value>
{
    alkParser.MethodCallContext ctx;
    Location reference;
    Location solution;

    public MethodCallState(alkParser.MethodCallContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.factor());
        }
        if (solution == null)
        {
            return request(FunctionCallVisitor.class, ctx.builtin_method(), reference);
        }

        setResult(new ExecutionResult(solution));
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
        }
        else if (solution == null)
        {
            solution = executionResult.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        MethodCallState copy = new MethodCallState(ctx, sm.getExecutionPayload());
        copy.reference = sm.getLocationMapper().get(reference);
        copy.solution = sm.getLocationMapper().get(solution);
        return super.decorate(copy, sm);
    }
}
