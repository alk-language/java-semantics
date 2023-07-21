package ro.uaic.info.alk.util;

import ro.uaic.info.alk.execution.AlkFunction;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;

import java.util.Collection;
import java.util.HashMap;
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
