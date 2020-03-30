package parser.env;

import execution.types.AlkValue;
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
    public Location clone() {
        return new Location(store);
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
