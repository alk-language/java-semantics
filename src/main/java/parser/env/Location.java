package parser.env;

import execution.types.AlkValue;
import execution.types.alkNotAValue.AlkNotAValue;
import parser.exceptions.AlkException;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class Location implements Value {

    private Store store;

    public Location(Store store)
    {
        this.store = store;
    }

    public Store getStore()
    {
        return this.store;
    }

    public AlkValue getValue()
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
    public AlkValue toRValue() {
        return getValue();
    }

    @Override
    public Location toLValue() {
        return this;
    }

    public Location assign(AlkValue value) {
        store.set(this, value);
        return this;
    }

    public boolean isUnknown() {
        return getValue() == null || getValue() instanceof AlkNotAValue;
    }
}
