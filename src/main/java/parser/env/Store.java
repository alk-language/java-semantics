package parser.env;

import parser.types.AlkValue;

import java.util.HashMap;
import java.util.Map;

public class Store
{

    private Map<Location, AlkValue> store = new HashMap<>();
    private int location = 0;

    public AlkValue get(Location location)
    {
        return store.get(location);
    }

    public void set(Location location, AlkValue value)
    {
        store.put(location, value.clone());
    }

    public Location malloc()
    {
        location++;
        Location newLocation = new Location(this, location);
        store.put(newLocation, null);
        return newLocation;
    }

    public Store makeClone()
    {
        Store copyStore = new Store();
        Map<Location, AlkValue> copy = new HashMap<>();
        for (Location key : store.keySet())
        {
            Location newLocation = new Location(copyStore, key.getLocation());
            AlkValue value = store.get(key).clone();
            copy.put(newLocation, value);
        }
        copyStore.store = copy;
        copyStore.location = location;
        return copyStore;
    }
}
