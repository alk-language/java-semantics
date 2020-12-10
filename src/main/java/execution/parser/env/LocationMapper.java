package execution.parser.env;

import java.util.HashMap;
import java.util.Map;

public class LocationMapper
{
    private Map<Location, Location> mapping = new HashMap<>();

    public LocationMapper()
    {

    }

    public void put(Location loc, Location newLoc) {
        mapping.put(loc, newLoc);
    }

    public Location get(Location loc)
    {
        return mapping.get(loc);
    }
}
