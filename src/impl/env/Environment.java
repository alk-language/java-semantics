package impl.env;

import impl.exceptions.AlkException;
import impl.types.AlkValue;

import java.util.HashMap;

import static impl.exceptions.AlkException.ERR_NO_REF;

public class Environment {

    //private HashMap<String, AlkValue> variables = new HashMap<>();
    private HashMap<String, Integer> variables = new HashMap<>(); // mapeaza o variabila la o zona de memorie (Store)

    public AlkValue lookup(String str) throws AlkException {
        if (variables.containsKey(str))
            return Store.get(variables.get(str));
        throw new AlkException(ERR_NO_REF);
    }

    public void update(String id, AlkValue value)
    {
        AlkValue copy = value.clone();
        if (variables.containsKey(id))
            Store.set(variables.get(id), copy);
        else
            variables.put(id, Store.setNew(copy));
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
}
