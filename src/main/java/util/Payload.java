package util;

import execution.Execution;

public class Payload {

    private Execution execution;

    public Payload (Execution execution)
    {
        this.execution = execution;
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
}
