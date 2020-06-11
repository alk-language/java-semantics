package util.functions;

import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import parser.env.Location;
import util.lambda.LocationGenerator;

import java.util.List;

public class Methods {

    @BuiltInMethod(paramNumber = 1)
    public static Location at(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return loc.toRValue().at(params.get(0), generator);
    }

    /*
    @BuiltInMethod(paramNumber = 1)
    public static Location delete(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().delete();
        return loc;
    }


    @BuiltInMethod(paramNumber = 1)
    public static Location first(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return loc.toRValue().first();
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location end(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return loc.toRValue().end();
    }
    */

    @BuiltInMethod(paramNumber = {1, 2})
    public static Location insert(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        if (params.size() == 1)
        {
            loc.toRValue().insert(generator.generate(params.get(0).clone(generator)));
            return loc;
        }
        else
        {
            loc.toRValue().insert(params.get(0), generator.generate(params.get(1).clone(generator)));
            return loc;
        }
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location popBack(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().popBack();
        return loc;
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location popFront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().popFront();
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location pushBack(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().pushBack(generator.generate(params.get(0).clone(generator)));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location pushFront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().pushFront(generator.generate(params.get(0).clone(generator)));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location remove(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().remove(params.get(0).clone(generator));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location removeAllEqTo(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().removeAllEqTo(params.get(0).clone(generator));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location removeAt(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().removeAt(params.get(0));
        return loc;
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location size(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return generator.generate(loc.toRValue().size());
    }

    @BuiltInMethod(paramNumber = {0, 1})
    public static Location split(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        if (params.size() == 0)
        {
            return loc.toRValue().split(generator);
        }
        else
        {
            return loc.toRValue().split(params.get(0), generator);
        }
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location topBack(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return loc.toRValue().topBack();
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location topFront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return loc.toRValue().topFront();
    }

    @BuiltInMethod(paramNumber = 2)
    public static Location update(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().update(params.get(0), generator.generate(params.get(1)));
        return loc;
    }
}
