package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.env.Environment;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.RefIDContext.class)
public class RefIDState extends ExecutionState<Value, Value>
{
    private String id;
    alkParser.RefIDContext ctx;


    public RefIDState(alkParser.RefIDContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload);
        this.ctx = ctx;
        this.id = ctx.ID().toString();
    }

    @Override
    public ExecutionState makeStep() {
        Environment env = getEnv();
        if (env.has(this.id))
        {
            setResult(new ExecutionResult(env.getLocation(this.id)));
        }
        else
        {
            setResult(new ExecutionResult(env.define(this.id)));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RefIDState copy = new RefIDState(ctx, sm.getExecutionPayload());
        copy.id = id;
        return super.decorate(copy, sm);
    }
}
