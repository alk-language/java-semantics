package execution;

import execution.exhaustive.EnvironmentMapper;
import execution.exhaustive.ExecutionStateMapper;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.env.StoreImpl;
import util.types.Storable;

import java.util.Set;

class ExecutionCloner
{

    public static Execution makeClone(Execution source)
    {
        StoreImpl copyStore = new StoreImpl();
        LocationMapper locMapping = new LocationMapper();

        Execution copy = new Execution(source.getConfig().clone(), source.getInterpreterManager().makeClone());
        copy.setStore(copyStore);
        Set<Location> sourceLocations = source.getStore().getLocations();

        for (Location loc : sourceLocations)
        {
            Location newLoc = copy.getStore().malloc();
            locMapping.put(loc, newLoc);
        }

        for (Location loc : sourceLocations)
        {
            Storable value = loc.getValue();
            Storable copyValue = value.weakClone(locMapping);
            copyStore.set(locMapping.get(loc), copyValue);
        }

        copy.setFuncManager(source.getFuncManager());

        EnvironmentMapper envMapping = source.cloneEnvironments(copy, locMapping, copyStore);
        ExecutionStateMapper stateMapping = source.getStack().cloneStates(copy, locMapping, envMapping);
        copy.setGlobal(envMapping.get(source.getGlobal()));

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        copy.setStack(stack);

        return copy;
    }
}