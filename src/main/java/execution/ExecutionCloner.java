package execution;

import execution.exhaustive.EnvironmentMapper;
import execution.exhaustive.ExecutionStateMapper;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.env.StoreImpl;
import execution.state.ExecutionCloneContext;
import util.pc.PathCondition;
import util.types.Storable;

import java.util.Set;

class ExecutionCloner
{

    public static ExecutionCloneContext makeClone(Execution source, ExecutionPool pool)
    {
        StoreImpl copyStore = new StoreImpl();
        LocationMapper locMapping = new LocationMapper(source.getStore(), copyStore);

        Execution copy;
        if (pool != null)
        {
            copy = pool.createExecution(source.getConfig().clone(), source.getInterpreterManager().makeClone());
        }
        else if (source.getPool() != null)
        {
            copy = source.getPool().createExecution(source.getConfig().clone(), source.getInterpreterManager().makeClone());
        }
        else
        {
            copy = new Execution(source.getConfig().clone(), source.getInterpreterManager().makeClone());
        }
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
            Storable copyValue = value == null ? null : value.weakClone(locMapping);
            copyStore.set(locMapping.get(loc), copyValue);
        }

        copy.setFuncManager(source.getFuncManager());

        EnvironmentMapper envMapping = source.cloneEnvironments(copy, locMapping, copyStore);
        ExecutionStateMapper stateMapping = source.getStack().cloneStates(copy, locMapping, envMapping);
        copy.setGlobal(envMapping.get(source.getGlobal()));
        copy.setPathCondition(new PathCondition(source.getPathCondition(), locMapping));

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        copy.setStack(stack);

        return new ExecutionCloneContext(copy, locMapping);
    }
}