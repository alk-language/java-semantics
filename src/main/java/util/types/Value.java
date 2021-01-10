package util.types;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import symbolic.CPValue;
import symbolic.SymbolicValueIface;
import util.lambda.LocationGenerator;

public interface Value
{
    Value weakClone(LocationMapper locationMapper);
    Value clone(LocationGenerator generator);
    Value toRValue();
    Location toLValue();
}
