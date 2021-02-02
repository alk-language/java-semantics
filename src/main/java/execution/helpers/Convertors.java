package execution.helpers;

import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;

import static execution.parser.exceptions.AlkException.ERR_INVALID_CONVERSION;

public class Convertors
{

    public static AlkInt toInt(AlkValue value)
    {
        if (value instanceof AlkInt)
        {
            return (AlkInt) value;
        }
        else if (value instanceof AlkFloat)
        {
            return new AlkInt(((AlkFloat) value).value.toBigInteger());
        }
        else
        {
            throw new AlkException(ERR_INVALID_CONVERSION);
        }
    }

    public static AlkFloat toFloat(AlkValue value)
    {
        if (value instanceof AlkInt)
        {
            return new AlkFloat(new BigDecimal(((AlkInt) value).value));
        }
        else if (value instanceof AlkFloat)
        {
            return (AlkFloat) value;
        }
        else
        {
            throw new AlkException(ERR_INVALID_CONVERSION);
        }
    }
}
