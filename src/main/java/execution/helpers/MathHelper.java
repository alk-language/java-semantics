package execution.helpers;

import ch.obermuhlner.math.big.BigDecimalMath;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import static parser.constants.Constants.MAX_DECIMALS;
import static parser.exceptions.AlkException.ERR_MATH_INT_OR_DOUBLE;

public class MathHelper {

    private static MathContext mathContext = new MathContext(MAX_DECIMALS);

    public static AlkValue sin(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.sin(value, mathContext));
    }

    public static AlkValue cos(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.cos(value, mathContext));
    }

    public static AlkValue tan(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.tan(value, mathContext));
    }

    public static AlkValue asin(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.asin(value, mathContext));
    }

    public static AlkValue acos(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.acos(value, mathContext));
    }

    public static AlkValue atan(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.atan(value, mathContext));
    }

    public static AlkValue pow(AlkValue x, AlkValue y) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        BigDecimal value2 = toBigDecimal(y);
        if (x.type.equals("Int") && y.type.equals("Int"))
            return new AlkInt(BigDecimalMath.pow(value, value2, mathContext).toBigInteger());
        return new AlkFloat(BigDecimalMath.pow(value, value2, mathContext));
    }

    public static AlkValue log(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.log(value, mathContext));
    }

    public static AlkValue sqrt(AlkValue x) throws AlkException {
        BigDecimal value = toBigDecimal(x);
        return new AlkFloat(BigDecimalMath.sqrt(value, mathContext));
    }

    public static AlkValue pi() throws AlkException {
        return new AlkFloat(BigDecimalMath.pi(mathContext));
    }

    public static AlkValue abs(AlkValue x) throws AlkException, InterpretorException {
        if(x.type.equals("Int"))
        {
            if (((AlkInt)x).value.compareTo(BigInteger.ZERO)<0)
                return x.negative();
            return x;
        }
        else
        {
            if (((AlkFloat)x).value.compareTo(BigDecimal.ZERO)<0)
                return x.negative();
            return x;
        }
    }

    private static BigDecimal toBigDecimal(AlkValue x) throws AlkException {
        if (!x.type.equals("Int") && !x.type.equals("Double"))
            throw new AlkException(ERR_MATH_INT_OR_DOUBLE);
        BigDecimal value = null;
        if (x.type.equals("Int"))
            value = new BigDecimal(((AlkInt)x).value);
        else
            value = ((AlkFloat)x).value;
        return value;
    }
}
