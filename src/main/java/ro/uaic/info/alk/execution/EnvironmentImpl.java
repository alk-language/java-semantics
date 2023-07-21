package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.exeptions.IdNotInEnvironmentException;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.LocationMapperIface;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.symbolic.ASTSimplifier;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnvironmentImpl
implements Environment
{
    private final StoreImpl store;
    private final Map<String, Location> variables = new HashMap<>();

    public EnvironmentImpl(StoreImpl store)
    {
        this.store = store;
    }

    public Location getLocation(String str)
    {
        return variables.computeIfAbsent(str, (key) -> {
            throw new IdNotInEnvironmentException(str);
        });
    }

    // TODO: doesn't look quite right ...
    public void setLocation(String name, Location location)
    {
        variables.put(name, location);
    }

    public Location define(String id)
    {
        Location loc = store.malloc();
        variables.put(id, loc);
        return loc;
    }

    public void update(String id, Storable value)
    {
        if (has(id))
        {
            store.set(variables.get(id), value);
        }
        else
        {
            define(id).setValue(value);
        }
    }

    public StoreImpl getStore()
    {
        return store;
    }

    public boolean has(String id)
    {
        return variables.containsKey(id);
    }

    @Override
    public Set<String> getVariables()
    {
        return variables.keySet();
    }

    public Environment clone(LocationMapper locMapping, StoreImpl store)
    {
        EnvironmentImpl copyEnv = new EnvironmentImpl(store);
        for (Map.Entry<String, Location> entry : variables.entrySet())
        {
            copyEnv.variables.put(entry.getKey(), locMapping.get(entry.getValue()));
        }
        return copyEnv;
    }

    @Override
    public String toString()
    {
        return this.toString(0);
    }

    @Override
    public String toString(int padding)
    {
        StringBuilder returnable = new StringBuilder();
        StringBuilder pad = new StringBuilder();
        for (int i=0; i < padding; i++)
        {
            pad.append(" ");
        }
        for (Map.Entry<String, Location> i : variables.entrySet())
        {
            Storable val = store.get(i.getValue());
            if (val instanceof SymbolicValue)
            {
                LocationMapperIface lm = loc -> loc;
                val = new SymbolicValue(((SymbolicValue) val).toAST().accept(new ASTSimplifier(lm, true)));
            }
            returnable.append(pad);
            returnable.append(i.getKey()).append(" |-> ").append(val).append('\n');
        }
        return pad.append(returnable.toString().trim()).toString();
    }

}
