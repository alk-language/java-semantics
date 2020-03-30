package parser.env;

import parser.exceptions.AlkException;
import execution.types.AlkValue;

import java.util.HashMap;
import java.util.Map;

import static parser.exceptions.AlkException.ERR_NO_REF;

public class Environment
{

    private Store store;

    private Map<String, Location> variables = new HashMap<>();

    public Environment(Store store)
    {
        this.store = store;
    }

    public AlkValue lookup(String str)
    {
        if (variables.containsKey(str))
        {
            return store.get(variables.get(str));
        }

        throw new AlkException(ERR_NO_REF + ": " + str);
    }

    public Location getLocation(String str)
    {
        if (variables.containsKey(str))
        {
            return variables.get(str);
        }

        throw new AlkException(ERR_NO_REF + ": " + str);
    }

    public Location define(String id)
    {
        Location loc = store.malloc();
        variables.put(id, loc);
        return loc;
    }

    public void update(String id, AlkValue value)
    {
        if (variables.containsKey(id))
            store.set(variables.get(id), value);
        else
            variables.put(id, store.malloc().assign(value));
    }

    public boolean has(String id)
    {
        return variables.containsKey(id);
    }

    public boolean remove(String id)
    {
        return variables.containsKey(id);
    }

    @Override
    public String toString()
    {
        StringBuilder returnable = new StringBuilder();
        for (Map.Entry<String, Location> i : variables.entrySet())
        {
            returnable.append(i.getKey()).append(" |-> ").append(store.get(i.getValue())).append('\n');
        }
        return returnable.toString();
    }

    public Environment makeClone(LocationMapper locMapping, Store store)
    {
        Environment copyEnv = new Environment(store);
        for (Map.Entry<String, Location> entry : variables.entrySet())
            copyEnv.variables.put(entry.getKey(), locMapping.get(entry.getValue()));
        return copyEnv;
    }

    public void setLocation(String name, Location location) {
        variables.put(name, location);
    }
}
