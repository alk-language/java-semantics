package ro.uaic.info.alk.util.functions;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.execution.helpers.Convertors;
import ro.uaic.info.alk.execution.helpers.MathHelper;
import ro.uaic.info.alk.execution.helpers.NonDeterministic;
import ro.uaic.info.alk.types.AlkFloat;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static ro.uaic.info.alk.exeptions.ErrorHandler.TO_INTERNAL;

public class Functions
implements FunctionsIface
{

    AlkConfiguration config;
    LocationGenerator generator;

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue sin(List<AlkValue> params)
    {
        return MathHelper.sin(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue cos(List<AlkValue> params)
    {
        return MathHelper.cos(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue tan(List<AlkValue> params)
    {
        return MathHelper.tan(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue asin(List<AlkValue> params)
    {
        return MathHelper.asin(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue acos(List<AlkValue> params)
    {
        return MathHelper.acos(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue atan(List<AlkValue> params)
    {
        return MathHelper.atan(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue log(List<AlkValue> params)
    {
        return MathHelper.log(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 2)
    public static AlkValue pow(List<AlkValue> params)
    {
        return MathHelper.pow(ParamHelper.getFloat(params, 0), ParamHelper.getFloat(params, 1));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue sqrt(List<AlkValue> params)
    {
        return MathHelper.sqrt(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 0)
    public static AlkValue pi(List<AlkValue> params)
    {
        return MathHelper.pi();
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue abs(List<AlkValue> params)
    {
        return MathHelper.abs(ParamHelper.getFloat(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue len(List<AlkValue> params)
    {
        return ParamHelper.getValue(params, 0).len();
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue _int(List<AlkValue> params)
    {
        return Convertors.toInt(ParamHelper.getValue(params, 0));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static AlkValue _float(List<AlkValue> params)
    {
        return Convertors.toFloat(ParamHelper.getValue(params, 0));
    }

    public Functions(AlkConfiguration config, LocationGenerator generator)
    {
        this.config = config;
        this.generator = generator;
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue print(List<AlkValue> params)
    {
        IOManager io = config.getIOManager();
        io.write(params.get(0).toString());
        return AlkNotAValue.INSTANCE;
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue singletonset(List<AlkValue> params)
    {
        return new AlkSet().insert(ParamHelper.getValue(params, 0).clone(generator));
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue uniformfloat(List<AlkValue> params)
    {
        BigDecimal total = new BigDecimal(
        BigInteger.valueOf(((AlkInt) ParamHelper.getValue(params, 0)).intValue(TO_INTERNAL)), AlkFloat.mc);
        total = total.multiply(new BigDecimal(BigInteger.valueOf(10), AlkFloat.mc)).pow(10); // TODO pow 10?
        config.interpretProbability(BigDecimal.ONE.divide(total, AlkFloat.mc));
        config.setProbabilistic(true);
        return NonDeterministic.getRandom(AlkInt.get(total.toBigInteger())).divide(AlkFloat.get(total));
    }

    @BuiltInFunctionImpl(paramNumber = 0)
    public AlkValue flip(List<AlkValue> params)
    {
        config.interpretProbability(BigDecimal.ONE.divide(BigDecimal.valueOf(2)));
        config.setProbabilistic(true);
        return NonDeterministic.getRandom(AlkInt.TWO);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue uniformperm(List<AlkValue> params)
    {
        AlkValue value = ParamHelper.getValue(params, 0);
        if (!(value instanceof AlkIterableValue))
        {
            throw new AlkException("Can't apply uniform perm on non-iterable value!");
        }
        AlkIterableValue iterableValue = (AlkIterableValue) value.clone(generator);
        iterableValue.shuffle();

        BigDecimal total = new BigDecimal(BigInteger.valueOf(1), AlkFloat.mc);
        for (int i = 1; i < ((AlkInt) iterableValue.size()).intValue(TO_INTERNAL); i++)
        {
            total = total.multiply(BigDecimal.valueOf(i));
        }
        config.interpretProbability(BigDecimal.ONE.divide(total, AlkFloat.mc));
        config.setProbabilistic(true);

        return iterableValue;
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue uniformnat(List<AlkValue> params)
    {
        BigDecimal total = new BigDecimal(
        BigInteger.valueOf(((AlkInt) ParamHelper.getValue(params, 0)).intValue(TO_INTERNAL)), AlkFloat.mc);
        config.interpretProbability(BigDecimal.ONE.divide(total, AlkFloat.mc));
        config.setProbabilistic(true);
        return NonDeterministic.getRandom(ParamHelper.getValue(params, 0));
    }
}
