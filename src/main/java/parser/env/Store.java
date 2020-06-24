package parser.env;

import execution.types.AlkValue;
import util.lambda.LocationGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store implements LocationGenerator
{

    private Map<Location, AlkValue> store = new HashMap<>();

    public AlkValue get(Location location)
    {
        return store.get(location);
    }

    public void set(Location location, AlkValue value)
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
    public Location generate(AlkValue value)
    {
        return malloc().assign(value.clone(this));
    }
}
