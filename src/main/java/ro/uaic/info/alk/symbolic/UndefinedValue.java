package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public class UndefinedValue
implements CPValue
{

    public boolean equals(CPValue value) {
        return value instanceof UndefinedValue;
    }

    @Override
    public String toString() {
        return "Undefined";
    }

    @Override
    public Storable weakClone(LocationMapper locationMapper) {
        return new UndefinedValue();
    }

    @Override
    public Storable clone(LocationGenerator generator) {
        return new UndefinedValue();
    }

    @Override
    public Storable toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't cast Undefined Value to Left Value.");
    }

}
