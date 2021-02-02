package execution.parser.env;

import util.types.Storable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreImpl
implements Store
{
    private final Map<Location, Storable> store = new HashMap<>();

    public Storable get(Location location)
    {
        return store.get(location);
    }

    public void set(Location location, Storable value)
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
    public Location generate(Storable value)
    {
        if (value == null)
        {
            return malloc();
        }
        else
        {
            return malloc().assign(value.clone(this));
        }
    }
}
