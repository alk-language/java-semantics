package ro.uaic.info.alk.util.types;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public interface Storable
{
    Storable weakClone(LocationMapper locationMapper);
    Storable clone(LocationGenerator generator);
    Storable toRValue();
    Location toLValue();
}
