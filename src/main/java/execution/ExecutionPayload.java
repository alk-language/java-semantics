package execution;

import ast.Payload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Environment;
import util.Configuration;
import util.types.Value;

public class ExecutionPayload
extends Payload
{

    private final Execution execution;
    private final Environment env;

    public ExecutionPayload(Execution execution, Environment env)
    {
        this.execution = execution;
        this.env = env;
    }

    public EnvironmentManager getEnvManager()
    {
        return execution.getEnvManager();
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

    public ExecutionPayload clone(SplitMapper sm)
    {
        return new ExecutionPayload(sm.getNewExecution(), sm.getEnvironmentMapper().get(this.env));
    }
}
