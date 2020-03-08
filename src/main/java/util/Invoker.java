package util;

import execution.types.AlkValue;
import parser.env.Location;
import parser.exceptions.AlkException;
import util.exception.InternalException;
import util.functions.BuiltInMethod;
import util.functions.Methods;
import util.lambda.LocationGenerator;
import util.types.Value;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static parser.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;
import static parser.exceptions.AlkException.ERR_PARAM_NUMBER;

public class Invoker {

    public static Value invokeMethod(String methodName, Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        try
        {
            methodName = NameMapper.processBuiltInName(methodName);
            Method method = Methods.class.getMethod(methodName, Location.class, List.class, LocationGenerator.class);

            if (method.getAnnotation(BuiltInMethod.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated method.");

            boolean valid = false;
            for (int paramNumber : method.getAnnotation(BuiltInMethod.class).paramNumber())
                if (paramNumber == params.size())
                {
                    valid = true;
                    break;
                }
            if (!valid)
                throw new AlkException(ERR_PARAM_NUMBER);

            return (Value) method.invoke(null, loc, params, generator);
        } catch (NoSuchMethodException e) {
            throw new AlkException(ERR_FUNCTION_UNDEFINED);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalException(e);
        }

    }

}
