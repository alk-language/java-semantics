package execution.parser.env;

import util.types.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreImpl implements Store
{
    private Map<Location, Value> store = new HashMap<>();

    public Value get(Location location)
    {
        return store.get(location);
    }

    public void set(Location location, Value value)
    {
        store.put(location, value);
    }

    public Location malloc()
    {
        Location newLocation = new Location(this);
        store.put(newLocation, null);
        return newLocation;
    }

    public Set<Location> getLocations()
    {
        return store.keySet();
    }

    @Override
    public Location generate(Value value)
    {
        return malloc().assign(value.clone(this));
    }
}
