package ro.uaic.info.alk.execution.helpers;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkFloat;
import ro.uaic.info.alk.types.AlkInt;

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
            return AlkInt.get(((AlkFloat) value));
        }
        else
        {
            throw new AlkException(AlkException.ERR_INVALID_CONVERSION);
        }
    }

    public static AlkFloat toFloat(AlkValue value)
    {
        if (value instanceof AlkInt)
        {
            return ((AlkInt) value).toFloat();
        }
        else if (value instanceof AlkFloat)
        {
            return (AlkFloat) value;
        }
        else
        {
            throw new AlkException(AlkException.ERR_INVALID_CONVERSION);
        }
    }
}
