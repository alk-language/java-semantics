package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.exceptions.BreakException;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.BreakStmtContext.class)
public class BreakState extends ExecutionState<Value, Value>
{
    alkParser.BreakStmtContext ctx;

    public BreakState(alkParser.BreakStmtContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new BreakException("Can't break while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BreakState copy = new BreakState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
