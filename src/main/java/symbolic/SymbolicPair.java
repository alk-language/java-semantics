package symbolic;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class SymbolicPair extends Pair<SymbolicValue, SymbolicValue> implements SymbolicValue {

    public SymbolicPair(SymbolicValue x, SymbolicValue y)
    {
        super(x, y);
    }

    @Override
    public boolean equals(SymbolicValue value)
    {
        if (!(value instanceof SymbolicPair))
            return false;

        SymbolicPair pair = (SymbolicPair) value;
        return this.x.equals(pair.x) && this.y.equals(pair.y);
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new SymbolicPair((SymbolicValue) x.weakClone(locationMapper), ((SymbolicValue) y.weakClone(locationMapper)));
    }

    @Override
    public Value clone(LocationGenerator generator) {
        return new SymbolicPair((SymbolicValue) x.clone(generator), ((SymbolicValue) y.clone(generator)));
    }

    @Override
    public Value toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't cast SymbolicPair to left value.");
    }
}
