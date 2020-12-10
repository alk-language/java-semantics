package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.exceptions.ContinueException;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.ContinueStmtContext.class)
public class ContinueState extends ExecutionState<Value, Value>
{
    alkParser.ContinueStmtContext ctx;

    public ContinueState(alkParser.ContinueStmtContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new ContinueException("Can't continue while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ContinueState copy = new ContinueState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
