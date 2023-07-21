package ro.uaic.info.alk.storage;

import java.util.HashMap;
import java.util.Map;

public class LocationMapper
implements LocationMapperIface
{
    private final Map<Location, Location> mapping = new HashMap<>();
    private StoreImpl sourceStore;
    private StoreImpl targetStore;

    public LocationMapper(StoreImpl sourceStore, StoreImpl targetStore)
    {
        this.sourceStore = sourceStore;
        this.targetStore = targetStore;
    }

    public void put(Location loc, Location newLoc) {
        mapping.put(loc, newLoc);
    }

    public Location get(Location loc)
    {
        return mapping.get(loc);
    }

    public StoreImpl getTargetStore()
    {
        return targetStore;
    }
}
