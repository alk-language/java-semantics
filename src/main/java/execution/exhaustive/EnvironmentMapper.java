package execution.exhaustive;

import execution.parser.env.Environment;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentMapper {

    private Map<Environment, Environment> mapping = new HashMap<>();

    public void put(Environment env, Environment newEnv) {
        mapping.put(env, newEnv);
    }

    public Environment get(Environment env)
    {
        return mapping.get(env);
    }
}
