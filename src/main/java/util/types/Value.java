package util.types;

import parser.env.Location;
import parser.env.LocationMapper;
import util.lambda.LocationGenerator;

public interface Value {

    Value weakClone(LocationMapper locationMapper);
    Value clone(LocationGenerator generator);
    Value toRValue();
    Location toLValue();
}
