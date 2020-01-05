package util;

import execution.state.ExecutionState;
import parser.env.Environment;
import util.exception.InternalException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// Static worker responsible for environment management
public class EnvironmentManager {

    private Map<ExecutionState, Environment> state2env = new HashMap<>();
    private Map<Environment, List<ExecutionState> > env2state = new HashMap<>();

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

    public EnvironmentManager clone() {
        // TODO: finish deep cloning
        EnvironmentManager clone = new EnvironmentManager();
        for (Map.Entry entry : state2env.entrySet())
        {
            // ExecutionState key = entry.getKey().clone();
            ExecutionState key = (ExecutionState) entry.getKey();

            Environment value = ((Environment) entry.getValue()).clone();

            clone.state2env.put(key, value);
        }

        /* for (Map.Entry entry : env2state.entrySet())
        {
            // ExecutionState key = entry.getKey().clone();
            Environment key = (Environment) entry.getKey();

            //Environment value = (Environment) entry.getValue().clone();
            Environment value = (Environment) entry.getValue();

            clone.state2env.put(key, value);
        } */
        return clone;
    }
}
