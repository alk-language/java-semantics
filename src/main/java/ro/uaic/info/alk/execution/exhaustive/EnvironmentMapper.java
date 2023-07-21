package ro.uaic.info.alk.execution.exhaustive;

import ro.uaic.info.alk.execution.Environment;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentMapper
{

    private final Map<Environment, Environment> mapping = new HashMap<>();

    public void put(Environment env, Environment newEnv) {
        mapping.put(env, newEnv);
    }

    public Environment get(Environment env)
    {
        return mapping.get(env);
    }
}
