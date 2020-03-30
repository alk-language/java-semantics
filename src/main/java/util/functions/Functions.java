package util.functions;

import execution.types.AlkValue;
import execution.helpers.Convertors;
import execution.helpers.MathHelper;
import execution.helpers.NonDeterministic;
import execution.types.alkNotAValue.AlkNotAValue;
import execution.types.alkSet.AlkSet;
import io.IOManager;
import parser.env.Location;
import util.Configuration;
import util.lambda.LocationGenerator;

import java.util.List;

public class Functions {

    Configuration config;
    LocationGenerator generator;

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

    public Functions(Configuration config, LocationGenerator generator)
    {
        this.config = config;
        this.generator = generator;
    }

    @BuiltInFunction(paramNumber = 1)
    public AlkValue print(List<AlkValue> params)
    {
        if (config == null || params == null || params.get(0) == null || config.getIOManager() == null)
        {
            int aci = 0;
        }
        IOManager io = config.getIOManager();
        io.write(params.get(0).toString());
        return new AlkNotAValue("Print does not return a value");
    }

    @BuiltInFunction(paramNumber = 1)
    public AlkValue singletonSet(List<AlkValue> params)
    {
        Location loc = generator.generate(ParamHelper.getValue(params, 0));
        return new AlkSet().insert(loc);
    }
}
