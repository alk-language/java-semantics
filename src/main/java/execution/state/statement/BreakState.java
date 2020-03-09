package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.exceptions.BreakException;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.BreakStmtContext.class)
public class BreakState extends ExecutionState
{
    alkParser.BreakStmtContext ctx;

    public BreakState(alkParser.BreakStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new BreakException("Can't break while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult result)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}
