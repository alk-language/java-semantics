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
}