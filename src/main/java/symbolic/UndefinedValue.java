package symbolic;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Storable;

public class UndefinedValue
implements CPValue
{

    @Override
    public boolean equals(CPValue value) {
        return value instanceof UndefinedValue;
    }

    @Override
    public String toString() {
        return "Undefined";
    }

    @Override
    public Storable weakClone(LocationMapper locationMapper) {
        return new UndefinedValue();
    }

    @Override
    public Storable clone(LocationGenerator generator) {
        return new UndefinedValue();
    }

    @Override
    public Storable toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't cast Undefined Value to Left Value.");
    }

}
