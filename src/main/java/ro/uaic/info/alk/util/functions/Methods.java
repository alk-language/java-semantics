package ro.uaic.info.alk.util.functions;

import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class Methods
{
    @BuiltInMethodAnno(paramNumber = 1)
    public static AlkValue at(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).at(params.get(0)).clone(generator);
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static AlkValue keys(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).keys().clone(generator);
    }

    @BuiltInMethodAnno(paramNumber = {1, 2})
    public static Location insert(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        if (params.size() == 1)
        {
            ((AlkValue) loc.toRValue()).insert(params.get(0).clone(generator));
        }
        else
        {
            ((AlkValue) loc.toRValue()).insert(params.get(0), params.get(1).clone(generator), generator);
        }
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static Location popback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).popBack();
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static Location popfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).popFront();
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location pushback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).pushBack((AlkValue) params.get(0).clone(generator), generator);
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location pushfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).pushFront((AlkValue) params.get(0).clone(generator), generator);
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location remove(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).remove(params.get(0));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location removealleqto(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).removeAllEqTo(params.get(0));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location removeat(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).removeAt(params.get(0));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static AlkValue size(Location loc, List<Storable> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).size();
    }

    @BuiltInMethodAnno(paramNumber = {0, 1})
    public static AlkValue split(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        if (params.size() == 0)
        {
            return ((AlkValue) loc.toRValue()).split(generator);
        }
        else
        {
            return ((AlkValue) loc.toRValue()).split(params.get(0), generator);
        }
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static AlkValue topback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).topBack();
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static AlkValue topfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        return ((AlkValue) loc.toRValue()).topFront();
    }

    @BuiltInMethodAnno(paramNumber = 2)
    public static Location update(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        ((AlkValue) loc.toRValue()).update(params.get(0), params.get(1).clone(generator), generator);
        return loc;
    }
}
