package util;

import execution.parser.env.AlkFunction;
import execution.parser.exceptions.AlkException;

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
            throw new AlkException(AlkException.ERR_FUNCTION_UNDEFINED);
        return functions.get(name);
    }
}
