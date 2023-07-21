package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.execution.helpers.AnnoHelper;
import ro.uaic.info.alk.state.Payload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.AlkConfiguration;

public class ExecutionPayload
extends Payload
{

    protected final AlkExecution execution;
    protected final Environment env;

    public ExecutionPayload(AlkExecution execution)
    {
        this(execution, execution.getGlobal());
    }

    public ExecutionPayload(AlkExecution execution, Environment env)
    {
        this.execution = execution;
        this.env = env;
    }

    public Environment getEnv()
    {
        return this.env;
    }

    public AlkExecution getExecution()
    {
        return execution;
    }

    public AlkConfiguration getConfiguration()
    {
        return execution.getConfiguration();
    }

    public AnnoHelper getAnnoHelper()
    {
        return execution.getAnnoHelper();
    }

    public ExecutionPayload clone(SplitMapper sm)
    {
        return new ExecutionPayload(sm.getNewExecution(), sm.getEnvironmentMapper().get(this.env));
    }

    public ExecutionPayload duplicate(AlkExecution exec, Environment env)
    {
        return new ExecutionPayload(exec, env);
    }
}
