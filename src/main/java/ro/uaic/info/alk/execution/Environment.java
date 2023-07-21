package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.util.types.Storable;

import java.util.Set;

public interface Environment
{
    Location getLocation(String str);
    void setLocation(String name, Location location);
    Location define(String id);
    void update(String id, Storable value);
    boolean has(String id);
    StoreImpl getStore();

    Environment clone(LocationMapper locMapping, StoreImpl store);
    String toString(int padding);

    Set<String> getVariables();
}
