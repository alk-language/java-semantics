package util.functions;

import parser.types.AlkValue;
import parser.types.alkSet.AlkSet;
import parser.visitors.helpers.Convertors;
import parser.visitors.helpers.MathHelper;
import parser.visitors.helpers.NonDeterministic;

import java.util.List;

public class Functions {

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue sin(List<AlkValue> params)
    {
        return MathHelper.sin(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue cos(List<AlkValue> params)
    {
        return MathHelper.cos(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue tan(List<AlkValue> params)
    {
        return MathHelper.tan(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue asin(List<AlkValue> params)
    {
        return MathHelper.asin(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue acos(List<AlkValue> params)
    {
        return MathHelper.acos(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue atan(List<AlkValue> params)
    {
        return MathHelper.atan(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue log(List<AlkValue> params)
    {
        return MathHelper.log(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 2)
    public static AlkValue pow(List<AlkValue> params)
    {
        return MathHelper.pow(ParamHelper.getFloat(params, 0), ParamHelper.getFloat(params, 1));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue sqrt(List<AlkValue> params)
    {
        return MathHelper.sqrt(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 0)
    public static AlkValue pi(List<AlkValue> params)
    {
        return MathHelper.pi();
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue abs(List<AlkValue> params)
    {
        return MathHelper.abs(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue singletonSet(List<AlkValue> params)
    {
        return new AlkSet().insert(ParamHelper.getValue(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue random(List<AlkValue> params)
    {
        return NonDeterministic.getRandom(ParamHelper.getValue(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue len(List<AlkValue> params)
    {
        return ParamHelper.getValue(params, 0).len();
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue _int(List<AlkValue> params)
    {
        return Convertors.toInt(ParamHelper.getValue(params, 0));
    }

    @BuiltInFunction(paramNumber = 1)
    public static AlkValue _float(List<AlkValue> params)
    {
        return Convertors.toFloat(ParamHelper.getValue(params, 0));
    }
}
