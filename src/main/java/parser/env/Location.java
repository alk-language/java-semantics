package parser.env;

import execution.types.AlkValue;
import util.types.Value;

public class Location implements Value {

    private Store store;
    private Integer location;

    public Location(Store store, Integer location)
    {
        this.store = store;
        this.location = location;
    }

    public Integer getLocation()
    {
        return this.location;
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
    public Location clone() {
        return new Location(store, location);
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

    public boolean isEmpty()
    {
        return getValue() == null;
    }
}
