package execution;

import execution.state.ExecutionState;
import execution.types.AlkValue;
import parser.env.Environment;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.env.Store;
import util.Configuration;
import util.EnvironmentManager;
import util.FuncManager;
import util.types.Value;

import java.util.Map;
import java.util.Set;

class ExecutionCloner {

    public static Execution makeClone(Execution source)
    {
        Store copyStore = new Store();
        LocationMapper locMapping = new LocationMapper();

        Execution copy = new Execution(source.getConfig().clone());
        copy.setStore(copyStore);
        Set<Location> sourceLocations = source.getStore().getLocations();

        for (Location loc : sourceLocations)
        {
            Location newLoc = copy.getStore().malloc();
            locMapping.put(loc, newLoc);
        }

        for (Location loc : sourceLocations)
        {
            AlkValue value = loc.getValue();
            AlkValue copyValue = value.weakClone(locMapping);
            copyStore.set(locMapping.get(loc), copyValue);
        }

        copy.setFuncManager(source.getFuncManager());

        Map<Environment, Environment> envMapping = source.getEnvManager().cloneEnvironments(locMapping, copyStore);
        Map<ExecutionState, ExecutionState> stateMapping = source.getStack().cloneStates(copy);

        EnvironmentManager envManager = source.getEnvManager().makeClone(copy, stateMapping, envMapping, copyStore);
        copy.setEnvManager(envManager);
        copy.setGlobal(envMapping.get(source.getGlobal()));

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        copy.setStack(stack);

        return copy;
    }

}
