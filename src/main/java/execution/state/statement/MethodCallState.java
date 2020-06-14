package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.function.FunctionCallVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.MethodCallContext.class)
public class MethodCallState extends ExecutionState
{
    alkParser.MethodCallContext ctx;
    Location reference;
    Location solution;

    public MethodCallState(alkParser.MethodCallContext ctx, Payload payload) {
        super(ctx, payload);
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

        result = new ExecutionResult(solution);
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (reference == null)
        {
            reference = result.getValue().toLValue();
        }
        else if (solution == null)
        {
            solution = result.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        MethodCallState copy = new MethodCallState(ctx, sm.getPayload());
        copy.reference = sm.getLocationMapper().get(reference);
        copy.solution = sm.getLocationMapper().get(solution);
        return super.decorate(copy, sm);
    }
}
