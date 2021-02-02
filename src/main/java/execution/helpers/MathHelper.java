package execution.helpers;

import ch.obermuhlner.math.big.BigDecimalMath;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import static execution.parser.constants.Constants.MAX_DECIMALS;
import static execution.parser.exceptions.AlkException.ERR_MATH_INT_OR_DOUBLE;

public class MathHelper {

    private static final MathContext mathContext = new MathContext(MAX_DECIMALS);

    public static AlkValue sin(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.sin(value, mathContext));
    }

    public static AlkValue cos(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.cos(value, mathContext));
    }

    public static AlkValue tan(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.tan(value, mathContext));
    }

    public static AlkValue asin(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.asin(value, mathContext));
    }

    public static AlkValue acos(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.acos(value, mathContext));
    }

    public static AlkValue atan(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.atan(value, mathContext));
    }

    public static AlkValue pow(AlkValue x, AlkValue y)
    {
        if (x instanceof AlkInt && y instanceof AlkInt)
        {
            return new AlkInt(BigDecimalMath.pow(toBigDecimal(x), toBigDecimal(y), mathContext).toBigInteger());
        }
        else
        {
            return new AlkFloat(BigDecimalMath.pow(toBigDecimal(x), toBigDecimal(y), mathContext));
        }
    }

    public static AlkValue log(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.log(value, mathContext));
    }

    public static AlkValue sqrt(AlkValue x)
    {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.sqrt(value, mathContext));
    }

    public static AlkValue pi()
    {
        return new AlkFloat(BigDecimalMath.pi(mathContext));
    }

    public static AlkValue abs(AlkValue x)
    {
        if (x instanceof AlkInt)
        {
            if (((AlkInt) x).value.compareTo(BigInteger.ZERO) < 0)
                return x.negative();
        }
        else if (x instanceof AlkFloat)
        {
            if (((AlkFloat) x).value.compareTo(BigDecimal.ZERO) < 0)
                return x.negative();
        }

        return x;
    }

    private static BigDecimal toBigDecimal(AlkValue x)
    {
        if (x instanceof AlkInt)
        {
            return new BigDecimal(((AlkInt) x).value);
        }
        else if (x instanceof AlkFloat)
        {
            return ((AlkFloat) x).value;
        }
        else
        {
            throw new AlkException(ERR_MATH_INT_OR_DOUBLE);
        }
    }
}
