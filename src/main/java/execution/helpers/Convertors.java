package execution.helpers;

import parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;

import static parser.exceptions.AlkException.ERR_INVALID_CONVERSION;

public class Convertors {

    public static AlkValue toInt(AlkValue value) throws AlkException {
        if (value.isDataStructure)
            throw new AlkException(ERR_INVALID_CONVERSION);
        switch (value.type)
        {
            case "Int": return value;
            case "Double": return new AlkInt(((AlkFloat)value).value.toBigInteger());
            default: throw new AlkException(ERR_INVALID_CONVERSION);
        }
    }

    public static AlkValue toFloat(AlkValue value) throws AlkException {
        if (value.isDataStructure)
            throw new AlkException(ERR_INVALID_CONVERSION);
        switch (value.type)
        {
            case "Double": return value;
            case "Int": return new AlkFloat(new BigDecimal(((AlkInt)value).value));
            default: throw new AlkException(ERR_INVALID_CONVERSION);
        }
    }
}
