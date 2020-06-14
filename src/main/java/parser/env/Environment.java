package parser.env;

import execution.types.AlkValue;

public interface Environment
{
    Location getLocation(String str);
    void setLocation(String name, Location location);
    Location define(String id);
    void update(String id, AlkValue value);
    boolean has(String id);
    String toString();
    Environment makeClone(LocationMapper locMapping, Store store);
    Store getStore();
}
