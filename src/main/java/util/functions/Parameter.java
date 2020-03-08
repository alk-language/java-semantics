package util.functions;

import parser.env.Location;
import util.exception.InternalException;
import util.types.Value;

public class Parameter implements Value {

    String name;
    boolean out;

    public Parameter(String name, boolean out) {
        this.name = name;
        this.out = out;
    }

    @Override
    public Value clone() {
        throw new InternalException("Can't clone a parameter.");
    }

    @Override
    public Value toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't get the location of one parameter type.");
    }

    public boolean isOut() {
        return out;
    }

    public String getName() {
        return name;
    }
}
