package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.Environment;

public class SymbolicExecutionPayload
extends ExecutionPayload
{
    public SymbolicExecutionPayload(AlkExecution execution, Environment env)
    {
        super(execution, env);
    }

    public SymbolicExecutionPayload duplicate(AlkExecution exec, Environment env)
    {
        return new SymbolicExecutionPayload(exec, env);
    }

    public ExecutionPayload clone(SplitMapper sm)
    {
        return new SymbolicExecutionPayload(sm.getNewExecution(), sm.getEnvironmentMapper().get(this.env));
    }
}
