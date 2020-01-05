package parser.env;

import parser.exceptions.AlkException;
import parser.types.AlkValue;

import java.util.HashMap;
import java.util.Map;

import static parser.exceptions.AlkException.ERR_NO_REF;

public class Environment {

    private Store store;
    private HashMap<String, Integer> variables = new HashMap<>();

    public Environment(Store store)
    {
        this.store = store;
    }

    public AlkValue lookup(String str) throws AlkException {
        if (variables.containsKey(str))
            return store.get(variables.get(str));
        throw new AlkException(ERR_NO_REF + ": " + str);
    }

    public Integer getLocation(String str) throws AlkException {
        if (variables.containsKey(str))
            return variables.get(str);
        throw new AlkException(ERR_NO_REF + ": " + str);
    }

    public void add(String id, Integer location)
    {
        variables.put(id, location);
    }

    public void update(String id, AlkValue value)
    {
        if (variables.containsKey(id))
            store.set(variables.get(id), value);
        else
            variables.put(id, store.setNew(value));
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
        for (Map.Entry<String, Integer> i : variables.entrySet())
        {
            returnable.append(i.getKey()).append(" |-> ").append(store.get(i.getValue())).append('\n');
        }
        return returnable.toString();
    }

    public Environment makeClone(Store store)
    {
        Environment clone = new Environment(store);
        for (Map.Entry entry : variables.entrySet())
        {
            Integer location = store.setNew(lookup((String) entry.getKey()));
            clone.variables.put((String)entry.getKey(), location);
        }
        return clone;
    }
}
