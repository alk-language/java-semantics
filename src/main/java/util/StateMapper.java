package util;

import execution.state.ExecutionState;
import parser.env.Location;

import java.util.HashMap;
import java.util.Map;

public class StateMapper
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
