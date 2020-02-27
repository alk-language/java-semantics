package util.types;

import parser.env.Location;
import util.lambda.LocationGenerator;

public interface Value {

    Value clone();
    Value toRValue();
    Location toLValue();
}
