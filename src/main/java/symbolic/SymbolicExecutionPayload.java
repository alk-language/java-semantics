package symbolic;

import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Environment;

public class SymbolicExecutionPayload
extends ExecutionPayload
{
    private final boolean toLValue;

    public SymbolicExecutionPayload(Execution execution, Environment env, boolean toLValue)
    {
        super(execution, env);
        this.toLValue = toLValue;
    }

    public boolean isToLValue()
    {
        return toLValue;
    }

    public SymbolicExecutionPayload duplicate(Execution exec, Environment env)
    {
        return new SymbolicExecutionPayload(exec, env, toLValue);
    }

    public ExecutionPayload clone(SplitMapper sm)
    {
        return new SymbolicExecutionPayload(sm.getNewExecution(), sm.getEnvironmentMapper().get(this.env), this.toLValue);
    }
}
