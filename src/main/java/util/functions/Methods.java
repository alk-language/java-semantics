package util.functions;

import execution.types.AlkValue;
import execution.parser.env.Location;
import util.lambda.LocationGenerator;

import java.util.List;

public class Methods {

    @BuiltInMethod(paramNumber = 1)
    public static Location at(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).at(params.get(0), generator);
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
            ((AlkValue) loc.toRValue()).insert(generator.generate(params.get(0).clone(generator)));
            return loc;
        }
        else
        {
            ((AlkValue) loc.toRValue()).insert(params.get(0), generator.generate(params.get(1).clone(generator)));
            return loc;
        }
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location popback(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).popBack();
        return loc;
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location popfront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).popFront();
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location pushback(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).pushBack(generator.generate(params.get(0).clone(generator)));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location pushfront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).pushFront(generator.generate(params.get(0).clone(generator)));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location remove(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).remove(params.get(0).clone(generator));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location removealleqto(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).removeAllEqTo(params.get(0).clone(generator));
        return loc;
    }

    @BuiltInMethod(paramNumber = 1)
    public static Location removeat(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).removeAt(params.get(0));
        return loc;
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location size(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return generator.generate(((AlkValue) loc.toRValue()).size());
    }

    @BuiltInMethod(paramNumber = {0, 1})
    public static Location split(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        if (params.size() == 0) {
            return ((AlkValue) loc.toRValue()).split(generator);
        }
        else {
            return ((AlkValue) loc.toRValue()).split(params.get(0), generator);
        }
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location topback(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).topBack();
    }

    @BuiltInMethod(paramNumber = 0)
    public static Location topfront(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).topFront();
    }

    @BuiltInMethod(paramNumber = 2)
    public static Location update(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).update(params.get(0), generator.generate(params.get(1)));
        return loc;
    }
}
