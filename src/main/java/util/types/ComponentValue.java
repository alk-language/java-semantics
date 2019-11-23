package util.types;

import parser.types.AlkValue;

public class ComponentValue extends Value {

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
}
