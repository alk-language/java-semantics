package util;

import execution.Execution;
import execution.state.ExecutionState;
import parser.types.AlkValue;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

public class Cloner {

    public static ArrayList<AlkValue> clone(List<AlkValue> src)
    {
        if (src == null)
            return null;

        ArrayList<AlkValue> dest = new ArrayList<>();
        for (AlkValue value : src)
        {
            dest.add(value.clone());
        }
        return dest;
    }

    public static ExecutionState clone(ExecutionState<? extends Value,? extends Value> state, Execution master)
    {
        Payload payload = new Payload(master);
        ExecutionState copy = state.clone(payload);
        EnvironmentManager envManager = master.getEnvManager();
        return copy;
    }
}
