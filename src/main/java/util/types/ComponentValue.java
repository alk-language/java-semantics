package util.types;

import parser.env.Location;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import util.lambda.LocationGenerator;

public class ComponentValue implements Value {

    private String identifier;
    private Location location;

    public ComponentValue(String identifier, Location location) {
        this.identifier = identifier;
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new ComponentValue(identifier, location.weakClone(locationMapper));
    }

    @Override
    public Value clone(LocationGenerator generator) {
        return new ComponentValue(identifier, location.clone(generator));
    }

    @Override
    public Value toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new AlkException("Can't obtain a reference out of this expression");
    }
}
