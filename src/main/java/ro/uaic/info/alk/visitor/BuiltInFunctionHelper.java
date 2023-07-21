package ro.uaic.info.alk.visitor;

import ro.uaic.info.alk.enums.AlkBuiltInFunction;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.HashMap;
import java.util.Map;

public class BuiltInFunctionHelper
{
    private final static Map<String, AlkBuiltInFunction> MAPPING;

    static
    {
        MAPPING = new HashMap<>();
        MAPPING.put("ABS", AlkBuiltInFunction.ABS);
        MAPPING.put("ASIN", AlkBuiltInFunction.ASIN);
        MAPPING.put("ACOS", AlkBuiltInFunction.ACOS);
        MAPPING.put("ATAN", AlkBuiltInFunction.ATAN);
        MAPPING.put("COS", AlkBuiltInFunction.COS);
        MAPPING.put("FLIP", AlkBuiltInFunction.FLIP);
        MAPPING.put("FLOAT", AlkBuiltInFunction.FLOAT);
        MAPPING.put("INTEGER", AlkBuiltInFunction.INTEGER);
        MAPPING.put("LEN", AlkBuiltInFunction.LEN);
        MAPPING.put("INT", AlkBuiltInFunction.INT);
        MAPPING.put("LOG", AlkBuiltInFunction.LOG);
        MAPPING.put("PI", AlkBuiltInFunction.PI);
        MAPPING.put("PRINT", AlkBuiltInFunction.PRINT);
        MAPPING.put("POW", AlkBuiltInFunction.POW);
        MAPPING.put("UNIFORMFLOAT", AlkBuiltInFunction.UNIFORMFLOAT);
        MAPPING.put("UNIFORMNAT", AlkBuiltInFunction.UNIFORMNAT);
        MAPPING.put("UNIFORMPERM", AlkBuiltInFunction.UNIFORMPERM);
        MAPPING.put("SIN", AlkBuiltInFunction.SIN);
        MAPPING.put("SINGLETONSET", AlkBuiltInFunction.SINGLETONSET);
        MAPPING.put("SQRT", AlkBuiltInFunction.SQRT);
        MAPPING.put("TAN", AlkBuiltInFunction.TAN);
    }

    public static AlkBuiltInFunction parse(String functionName)
    {
        functionName = functionName.toUpperCase();
        if (MAPPING.containsKey(functionName))
        {
            return MAPPING.get(functionName);
        }
        throw new InternalException("Unidentified build in method: " + functionName);
    }
}
