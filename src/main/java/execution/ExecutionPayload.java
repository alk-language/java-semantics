package execution;

import execution.helpers.AnnoHelper;
import state.Payload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Environment;
import util.Configuration;
import visitor.stateful.StatefulInterpreterManager;

public class ExecutionPayload
extends Payload
{

    protected final Execution execution;
    protected final Environment env;

    public ExecutionPayload(Execution execution, Environment env)
    {
        this.execution = execution;
        this.env = env;
    }

    public Environment getEnv()
    {
        return this.env;
    }

    public Execution getExecution()
    {
        return execution;
    }

    public Configuration getConfiguration()
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

    public ExecutionPayload duplicate(Execution exec, Environment env)
    {
        return new ExecutionPayload(exec, env);
    }
}
