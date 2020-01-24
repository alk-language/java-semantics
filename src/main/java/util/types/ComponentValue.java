package util.types;

import parser.env.Location;
import parser.exceptions.AlkException;
import parser.types.AlkValue;

public class ComponentValue implements Value {

    private String identifier;
    private AlkValue value;

    public ComponentValue(String identifier, AlkValue value) {
        this.identifier = identifier;
        this.value = value;
    }


    public AlkValue getValue() {
        return value;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Value clone() {
        return new ComponentValue(identifier, value.clone());
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
