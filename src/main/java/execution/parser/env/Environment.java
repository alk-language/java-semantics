package execution.parser.env;

import util.types.Storable;

import java.util.Set;

public interface Environment
{
    Location getLocation(String str);
    void setLocation(String name, Location location);
    Location define(String id);
    void update(String id, Storable value);
    boolean has(String id);
    StoreImpl getStore();

    Environment makeClone(LocationMapper locMapping, StoreImpl store);
    String toString(int padding);

    Set<String> getVariables();
}
