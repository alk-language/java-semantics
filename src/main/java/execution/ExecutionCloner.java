package execution;

import execution.state.ExecutionState;
import execution.types.AlkValue;
import parser.env.Environment;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.env.Store;
import util.*;
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

        EnvironmentMapper envMapping = source.getEnvManager().cloneEnvironments(locMapping, copyStore);
        StateMapper stateMapping = source.getStack().cloneStates(copy, locMapping, envMapping);

        EnvironmentManager envManager = source.getEnvManager().makeClone(stateMapping, envMapping);
        copy.setEnvManager(envManager);
        copy.setGlobal(envMapping.get(source.getGlobal()));

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        copy.setStack(stack);

        return copy;
    }

}