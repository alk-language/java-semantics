package util;

import execution.Execution;
import parser.env.Location;
import util.types.Value;

public class Payload {

    private Execution execution;
    private Value value;

    public Payload (Execution execution)
    {
        this.execution = execution;
    }

    public Payload (Execution execution, Value value)
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
