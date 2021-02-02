package util.types;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.lambda.LocationGenerator;

public interface Storable
{
    Storable weakClone(LocationMapper locationMapper);
    Storable clone(LocationGenerator generator);
    Storable toRValue();
    Location toLValue();
}
