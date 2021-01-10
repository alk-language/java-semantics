package symbolic;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class CPPair extends Pair<CPValue, CPValue> implements CPValue {

    public CPPair(CPValue x, CPValue y)
    {
        super(x, y);
    }

    @Override
    public boolean equals(CPValue value)
    {
        if (!(value instanceof CPPair))
            return false;

        CPPair pair = (CPPair) value;
        return this.x.equals(pair.x) && this.y.equals(pair.y);
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new CPPair((CPValue) x.weakClone(locationMapper), ((CPValue) y.weakClone(locationMapper)));
    }

    @Override
    public Value clone(LocationGenerator generator) {
        return new CPPair((CPValue) x.clone(generator), ((CPValue) y.clone(generator)));
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
