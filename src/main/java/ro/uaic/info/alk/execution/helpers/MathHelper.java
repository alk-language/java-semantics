package ro.uaic.info.alk.execution.helpers;

import ch.obermuhlner.math.big.BigDecimalMath;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkFloat;
import ro.uaic.info.alk.types.AlkInt;

import java.math.BigDecimal;
import java.math.BigInteger;

import static ro.uaic.info.alk.exeptions.ErrorHandler.TO_INTERNAL;

public class MathHelper
{

    public static AlkValue sin(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.sin(value, AlkFloat.mc));
    }

    public static AlkValue cos(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.cos(value, AlkFloat.mc));
    }

    public static AlkValue tan(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.tan(value, AlkFloat.mc));
    }

    public static AlkValue asin(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.asin(value, AlkFloat.mc));
    }

    public static AlkValue acos(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.acos(value, AlkFloat.mc));
    }

    public static AlkValue atan(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.atan(value, AlkFloat.mc));
    }

    public static AlkValue pow(AlkValue x, AlkValue y)
    {
        if (x instanceof AlkInt && y instanceof AlkInt)
        {
            return AlkInt.get(BigDecimalMath.pow(toBigDecimal(x), toBigDecimal(y), AlkFloat.mc).toBigInteger());
        }
        else
        {
            return AlkFloat.get(BigDecimalMath.pow(toBigDecimal(x), toBigDecimal(y), AlkFloat.mc));
        }
    }

    public static AlkValue log(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.log(value, AlkFloat.mc));
    }

    public static AlkValue sqrt(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return AlkFloat.get(BigDecimalMath.sqrt(value, AlkFloat.mc));
    }

    public static AlkValue pi()
    {
        return AlkFloat.get(BigDecimalMath.pi(AlkFloat.mc));
    }

    public static AlkValue abs(AlkValue x)
    {
        if (x instanceof AlkInt)
        {
            if (((AlkInt) x).lower(AlkInt.ZERO).isTrue())
                return x.negative();
        }
        else if (x instanceof AlkFloat)
        {
            if (x.lower(AlkFloat.get(BigInteger.ZERO)).isTrue())
                return x.negative();
        }

        return x;
    }

    private static BigDecimal toBigDecimal(AlkValue x)
    {
        if (x instanceof AlkInt)
        {
            return new BigDecimal(((AlkInt) x).intValue(TO_INTERNAL), AlkFloat.mc);
        }
        else if (x instanceof AlkFloat)
        {
            return ((AlkFloat) x).unwrap();
        }
        else
        {
            throw new AlkException(AlkException.ERR_MATH_INT_OR_DOUBLE);
        }
    }
}
