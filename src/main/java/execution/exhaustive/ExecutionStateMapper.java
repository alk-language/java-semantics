package execution.exhaustive;

import execution.state.ExecutionState;

import java.util.HashMap;
import java.util.Map;

public class ExecutionStateMapper
{
    private Map<ExecutionState, ExecutionState> mapping = new HashMap<>();

    public void put(ExecutionState state, ExecutionState newstate) {
        mapping.put(state, newstate);
    }

    public ExecutionState get(ExecutionState state)
    {
        return mapping.get(state);
    }
}
