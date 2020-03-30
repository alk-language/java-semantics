package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.function.FunctionCallVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.RefPointMethodContext.class)
public class RefPointMethodState extends ExecutionState
{

    alkParser.RefPointMethodContext ctx;
    private Location reference;
    private Location solution;

    public RefPointMethodState(alkParser.RefPointMethodContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.ref_name());
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
    public ExecutionState clone(Payload payload) {
        RefPointMethodState copy = new RefPointMethodState(ctx, payload);
        copy.reference = reference; // should be mapped
        copy.solution = solution; // should be mapped
        return super.decorate(copy);
    }
}
