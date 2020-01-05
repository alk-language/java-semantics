package parser.env;

import parser.types.AlkValue;

import java.util.HashMap;

public class Store {

    private HashMap<Integer, AlkValue> store = new HashMap<>();
    private int location = 0;

    public AlkValue get(Integer location)
    {
        return store.get(location);
    }

    public void set(Integer location, AlkValue value)
    {
        store.put(location, value.clone());
    }

    Integer setNew(AlkValue value) {
        location++;
        store.put(location, value.clone());
        return location;
    }

    public Store makeClone() {
        Store copyStore = new Store();
        HashMap<Integer, AlkValue> copy = new HashMap<>();
        for (Integer key : store.keySet())
        {
            copy.put(key, store.get(key));
        }
        copyStore.store = copy;
        copyStore.location = location;
        return copyStore;
    }
}
