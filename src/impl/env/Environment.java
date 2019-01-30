package impl.env;

import impl.exceptions.AlkException;
import impl.types.AlkValue;

import java.util.HashMap;

import static impl.exceptions.AlkException.ERR_NO_REF;

public class Environment {

    private HashMap<String, AlkValue> variables = new HashMap<>();

    public AlkValue lookup(String str) throws AlkException {
        if (variables.containsKey(str))
            return variables.get(str);
        throw new AlkException(ERR_NO_REF);
    }

    public void update(String id, AlkValue value)
    {
        variables.put(id, value);
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
