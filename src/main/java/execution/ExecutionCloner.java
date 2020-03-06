package execution;

import execution.state.ExecutionState;
import parser.env.Environment;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.env.Store;
import util.Configuration;
import util.EnvironmentManager;

import java.util.Map;

class ExecutionCloner {

    private Execution source;
    private Execution copy;
    private Store copyStore;
    private Map<ExecutionState, ExecutionState> stateMapping;
    private Map<Environment, Environment> envMapping;

    ExecutionCloner(Execution exec)
    {
        source = exec;
        copyStore = source.getStore().makeClone();
        copy = new Execution(exec.getConfig());
        envMapping = source.getEnvManager().cloneEnvironments(copyStore);
        stateMapping = source.getStack().cloneStates(copy);
    }

    Execution execute() {

        Configuration config = source.getConfig();

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        EnvironmentManager envManager = source.getEnvManager().makeClone(copy, stateMapping, envMapping, copyStore);

        copy.setStore(copyStore);
        copy.setConfig(config);
        copy.setGlobal(envMapping.get(source.getGlobal()));
        copy.setEnvManager(envManager);
        copy.setStack(stack);
        return copy;
    }

}
