package symbolic;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class OverdefinedValue implements SymbolicValue {

    @Override
    public boolean equals(SymbolicValue value) {
        return value instanceof OverdefinedValue;
    }

    @Override
    public String toString() {
        return "Overdefined";
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new OverdefinedValue();
    }

    @Override
    public Value clone(LocationGenerator generator) {
        return new OverdefinedValue();
    }

    @Override
    public Value toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't cast Overdefined Value to Left Value.");
    }
}
