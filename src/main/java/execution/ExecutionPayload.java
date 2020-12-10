package execution;

import ast.Payload;
import util.Configuration;
import util.types.Value;

public class ExecutionPayload extends Payload {

    private Execution execution;
    private Value value;

    public ExecutionPayload(Execution execution)
    {
        this.execution = execution;
    }

    public ExecutionPayload(Execution execution, Value value)
    {
        this.execution = execution;
        this.value = value;
    }

    public EnvironmentManager getEnvManager() {
        return execution.getEnvManager();
    }

    public Execution getExecution() {
        return execution;
    }

    public Configuration getConfiguration() {
        return execution.getConfiguration();
    }

    public Value getValue() {
        return value;
    }
}
