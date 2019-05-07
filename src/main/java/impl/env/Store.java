package impl.env;

import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;

import java.util.HashMap;

public class Store {

    private static HashMap<Integer, AlkValue> store = new HashMap<>();
    private static int location = 0;

    public static AlkValue get(Integer location)
    {
        return store.get(location);
    }

    public static void set(Integer location, AlkValue value)
    {
        store.put(location, value.clone());
    }

    public static Integer setNew(AlkValue value) {
        location++;
        store.put(location, value.clone());
        return location;
    }

    public static void printStore()
    {
        System.out.print(store.toString());
    }
}
