package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public class OverdefinedValue implements CPValue {

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
