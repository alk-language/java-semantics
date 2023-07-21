package ro.uaic.info.alk.storage;

import ro.uaic.info.alk.util.types.Storable;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class StoreImpl
implements Store
{
    private final Map<Location, Storable> store = new WeakHashMap<>();

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
            return malloc().setValue(value.clone(this));
        }
    }
}

// store : Location -> Storable (Value)