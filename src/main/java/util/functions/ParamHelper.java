package util.functions;

import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_INVALID_PARAM;

class ParamHelper {

    // TODO: create builtin converting method
    static AlkFloat getFloat(List<AlkValue> params, int i) {
        AlkValue value = params.get(i);
        if (!(value instanceof AlkFloat) && !(value instanceof AlkInt))
            throw new AlkException(ERR_INVALID_PARAM);

        BigDecimal bd;
        if (value instanceof AlkInt)
            bd = new BigDecimal(((AlkInt)value).value);
        else
            bd = ((AlkFloat)value).value;
        return new AlkFloat(bd);
    }

    public static AlkValue getValue(List<AlkValue> params, int i) {
        return params.get(i);
    }
}
