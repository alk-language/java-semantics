package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.execution.exhaustive.EnvironmentMapper;
import ro.uaic.info.alk.execution.exhaustive.ExecutionStateMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.execution.state.ExecutionCloneContext;
import ro.uaic.info.alk.util.pc.PathCondition;
import ro.uaic.info.alk.util.types.Storable;

import java.util.Set;

class ExecutionCloner
{

    public static ExecutionCloneContext makeClone(AlkExecution source, ExecutionPool pool)
    {
        StoreImpl copyStore = new StoreImpl();
        LocationMapper locMapping = new LocationMapper(source.getStore(), copyStore);

        AlkExecution copy;
        if (pool != null)
        {
            copy = pool.createExecution(source.getConfig().clone(),
                                        (ExecutionInterpreter) source.getInterpreter().makeClone());
        }
        else if (source.getPool() != null)
        {
            copy = source.getPool().createExecution(source.getConfig().clone(),
                                                    (ExecutionInterpreter) source.getInterpreter().makeClone());
        }
        else
        {
            copy = new AlkExecution(source.getConfig().clone(),
                                    (ExecutionInterpreter) source.getInterpreter().makeClone());
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

        CallStack callStack = source.getCallStack().makeClone(copy, stateMapping);
        copy.setCallStack(callStack);

        return new ExecutionCloneContext(copy, locMapping);
    }
}