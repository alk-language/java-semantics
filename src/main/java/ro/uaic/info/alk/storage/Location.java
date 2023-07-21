package ro.uaic.info.alk.storage;

import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.symbolic.CPValue;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

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

    public Location setValue(Storable value) {
        store.set(this, value);
        return this;
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

    public boolean isUnknown() {
        return getValue() == null || getValue() instanceof AlkNotAValue;
    }

    public boolean equals(CPValue value)
    {
        return this == value;
    }

    @Override
    public boolean isFullConcrete()
    {
        return true;
    }
}
