package util;

import execution.parser.env.AlkFunction;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NoSuchFunctionException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncManager {

    Map<String, AlkFunction> functions;

    public FuncManager() {
        functions = new HashMap<>();
    }

    public void define(AlkFunction function) {
        functions.put(function.getName(), function);
    }

    public AlkFunction getFunction(String name) {
        if (!functions.containsKey(name))
        {
            throw new NoSuchFunctionException(name);
        }
        return functions.get(name);
    }

    public Collection<AlkFunction> getFunctions()
    {
        return functions.values();
    }
}
