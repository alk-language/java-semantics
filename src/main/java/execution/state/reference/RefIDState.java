package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Environment;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.RefIDContext.class)
public class RefIDState extends ExecutionState
{
    private String id;
    alkParser.RefIDContext ctx;


    public RefIDState(alkParser.RefIDContext ctx, Payload payload) {
        super(ctx, payload);
        this.ctx = ctx;
        this.id = ctx.ID().toString();
    }

    @Override
    public ExecutionState makeStep() {
        Environment env = getEnv();
        if (env.has(this.id))
        {
            result = new ExecutionResult(env.getLocation(this.id));
        }
        else
        {
            result = new ExecutionResult(env.define(this.id));
        }


        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        RefIDState copy = new RefIDState(ctx, payload);
        copy.id = id;
        return super.decorate(copy);
    }
}
