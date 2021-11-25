package symbolic;

import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Environment;

public class SymbolicExecutionPayload
extends ExecutionPayload
{
    public SymbolicExecutionPayload(Execution execution, Environment env)
    {
        super(execution, env);
    }

    public SymbolicExecutionPayload duplicate(Execution exec, Environment env)
    {
        return new SymbolicExecutionPayload(exec, env);
    }

    public ExecutionPayload clone(SplitMapper sm)
    {
        return new SymbolicExecutionPayload(sm.getNewExecution(), sm.getEnvironmentMapper().get(this.env));
    }
}
