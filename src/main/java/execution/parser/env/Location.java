package execution.parser.env;

import execution.types.ConcreteValue;
import execution.types.alkNotAValue.AlkNotAValue;
import symbolic.CPValue;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Storable;

public class Location
implements ConcreteValue
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

    public Storable getValue()
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
    public Storable toRValue() {
        return getValue();
    }

    @Override
    public Location toLValue() {
        return this;
    }

    public Location assign(Storable value) {
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
