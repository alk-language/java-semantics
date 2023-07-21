package ro.uaic.info.alk.util.lambda;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.util.types.Storable;

public interface LocationGenerator
{
    Location generate(Storable value);
}
