package util.types;

import parser.env.Location;

public interface Value {

    Value clone();
    Value toRValue();
    Location toLValue();
}
