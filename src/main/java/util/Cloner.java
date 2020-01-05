package util;

import parser.types.AlkValue;

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