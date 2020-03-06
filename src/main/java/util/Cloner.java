package util;

import execution.Execution;
import execution.types.AlkValue;
import parser.env.Location;
import util.lambda.LocationGenerator;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

public class Cloner {

    public static List<AlkValue> clone(List<AlkValue> src, LocationGenerator generator)
    {
        if (src == null)
            return null;

        ArrayList<AlkValue> dest = new ArrayList<>();
        for (AlkValue value : src)
        {
            dest.add(value.clone(generator));
        }
        return dest;
    }

}