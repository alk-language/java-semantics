package impl.env;

import impl.exceptions.AlkException;
import impl.types.AlkValue;

import java.util.HashMap;
import java.util.Map;

import static impl.exceptions.AlkException.ERR_NO_REF;

public class Environment {

    //private HashMap<String, AlkValue> variables = new HashMap<>();
    private HashMap<String, Integer> variables = new HashMap<>(); // mapeaza o variabila la o zona de memorie (Store)

    public AlkValue lookup(String str) throws AlkException {
        if (variables.containsKey(str))
            return Store.get(variables.get(str));
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
            Store.set(variables.get(id), value);
        else
            variables.put(id, Store.setNew(value));
    }

    public boolean has(String id)
    {
        if (variables.containsKey(id))
            return true;
        return false;
    }

    public boolean remove(String id)
    {
        if (variables.containsKey(id))
            return true;
        return false;
    }

    @Override public String toString()
    {
        String returnable = "";
        for (Map.Entry<String, Integer> i : variables.entrySet())
        {
            returnable = returnable + i.getKey() + " |-> " + Store.get(i.getValue()) + '\n';
        }
        return returnable;
    }
}
