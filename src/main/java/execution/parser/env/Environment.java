package execution.parser.env;

import util.types.Value;

public interface Environment
{
    Location getLocation(String str);
    void setLocation(String name, Location location);
    Location define(String id);
    void update(String id, Value value);
    boolean has(String id);
    String toString();
    Environment makeClone(LocationMapper locMapping, StoreImpl store);
    StoreImpl getStore();
}
