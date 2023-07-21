package ro.uaic.info.alk.util.functions;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkFloat;
import ro.uaic.info.alk.types.AlkInt;

import java.util.List;

import static ro.uaic.info.alk.exeptions.AlkException.ERR_INVALID_PARAM;

class ParamHelper {

    // TODO: create builtin converting method
    static AlkFloat getFloat(List<AlkValue> params, int i)
    {
        AlkValue value = params.get(i);
        if (value instanceof AlkFloat)
        {
            return (AlkFloat) value;
        }
        else if (value instanceof AlkInt)
        {
            return ((AlkInt) value).toFloat();
        }
        else
        {
            throw new AlkException(ERR_INVALID_PARAM);
        }
    }

    public static AlkValue getValue(List<AlkValue> params, int i) {
        return params.get(i);
    }
}
