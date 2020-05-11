package util.functions;

import parser.env.Location;
import parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

public class Parameter implements Value {

    String name;
    boolean out;

    public Parameter(String name, boolean out) {
        this.name = name;
        this.out = out;
    }

    @Override
    public Value clone(LocationGenerator generator)
    {
        return new Parameter(name, out);
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new Parameter(name, out);
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
