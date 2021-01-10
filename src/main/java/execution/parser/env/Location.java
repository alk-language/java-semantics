package execution.parser.env;

import execution.types.BaseValue;
import execution.types.alkNotAValue.AlkNotAValue;
import symbolic.CPValue;
import symbolic.SymbolicValueIface;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class Location
implements BaseValue
{
    private final StoreImpl store;

    public Location(StoreImpl store)
    {
        this.store = store;
    }

    public StoreImpl getStore()
    {
        return this.store;
    }

    public Value getValue()
    {
        return store.get(this);
    }

    @Override
    public Location clone(LocationGenerator generator) {
        throw new InternalException("Can't deep clone a location");
    }

    @Override
    public Location weakClone(LocationMapper locationMapper) {
        return locationMapper.get(this);
    }

    @Override
    public Value toRValue() {
        return getValue();
    }

    @Override
    public Location toLValue() {
        return this;
    }

    public Location assign(Value value) {
        store.set(this, value);
        return this;
    }

    public boolean isUnknown() {
        return getValue() == null || getValue() instanceof AlkNotAValue;
    }

    @Override
    public boolean equals(CPValue value)
    {
        return this == value;
    }
}
