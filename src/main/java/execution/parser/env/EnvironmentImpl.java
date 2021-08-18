package execution.parser.env;

import execution.types.AlkValue;
import execution.parser.exceptions.IdNotInEnvironmentException;
import util.types.Storable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnvironmentImpl
implements Environment
{
    protected StoreImpl store;

    protected Map<String, Location> variables = new HashMap<>();

    public EnvironmentImpl(StoreImpl store)
    {
        this.store = store;
    }

    public Location getLocation(String str)
    {
        if (variables.containsKey(str))
        {
            return variables.get(str);
        }

        throw new IdNotInEnvironmentException(str);
    }

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
        if (variables.containsKey(id))
            store.set(variables.get(id), value);
        else
            variables.put(id, store.malloc().setValue(value));
    }


    public StoreImpl getStore()
    {
        return store;
    }

    public void update(String id, AlkValue value)
    {
        if (variables.containsKey(id))
            store.set(variables.get(id), value);
        else
            variables.put(id, store.malloc().setValue(value));
    }

    public boolean has(String id)
    {
        return variables.containsKey(id);
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
            returnable.append(pad);
            returnable.append(i.getKey()).append(" |-> ").append(store.get(i.getValue())).append('\n');
        }
        return pad.append(returnable.toString().trim()).toString();
    }

    @Override
    public Set<String> getVariables()
    {
        return variables.keySet();
    }

    public Environment makeClone(LocationMapper locMapping, StoreImpl store)
    {
        EnvironmentImpl copyEnv = new EnvironmentImpl(store);
        for (Map.Entry<String, Location> entry : variables.entrySet())
        {
            copyEnv.variables.put(entry.getKey(), locMapping.get(entry.getValue()));
        }
        return copyEnv;
    }

}
