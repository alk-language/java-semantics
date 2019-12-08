package util;

import execution.Execution;
import execution.state.ExecutionState;
import parser.env.Environment;
import util.exception.InternalException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// Static worker responsible for environment management
public class EnvironmentManager {

    private static Map<ExecutionState, Environment> state2env = new HashMap<>();
    private static Map<Environment, List<ExecutionState>> env2state = new HashMap<>();

    public void link(ExecutionState state, Environment env)
    {
        if (env == null)
            throw new InternalException("Can't link a state to a null environment.");

        state2env.put(state, env);

        if (env2state.get(env) == null)
        {
            List<ExecutionState> list = new LinkedList<>();
            env2state.put(env, list);
        }

        env2state.get(env).add(state);
    }

    public Environment getEnv(ExecutionState state) {
        if (!state2env.containsKey(state))
            throw new InternalException("The environment manager is broken. No environment could be found for a state");

        return state2env.get(state);
    }
}
