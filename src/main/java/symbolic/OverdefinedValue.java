package symbolic;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Storable;

public class OverdefinedValue implements CPValue {

    @Override
    public boolean equals(CPValue value) {
        return value instanceof OverdefinedValue;
    }

    @Override
    public String toString() {
        return "Overdefined";
    }

    @Override
    public Storable weakClone(LocationMapper locationMapper) {
        return new OverdefinedValue();
    }

    @Override
    public Storable clone(LocationGenerator generator) {
        return new OverdefinedValue();
    }

    @Override
    public Storable toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't cast Overdefined Value to Left Value.");
    }
}
