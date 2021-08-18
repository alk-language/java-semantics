package util;

import execution.exhaustive.NameMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import util.exception.InternalException;
import util.functions.BuiltInMethod;
import util.functions.Methods;
import util.lambda.LocationGenerator;
import util.types.Storable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static execution.parser.exceptions.AlkException.*;

public class Invoker {

    public static Storable invokeMethod(String methodName,
                                        Location loc,
                                        List<Storable> params,
                                        LocationGenerator generator,
                                        FunctionsSolver solver)
    {
        try
        {
            methodName = NameMapper.processBuiltInName(methodName);
            Method method = solver.solve(methodName);

            if (method.getAnnotation(BuiltInMethod.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated method.");

            boolean valid = false;
            for (int paramNumber : method.getAnnotation(BuiltInMethod.class).paramNumber())
                if (paramNumber == params.size()) {
                    valid = true;
                    break;
                }

            if (!valid)
                throw new AlkException(ERR_PARAM_NUMBER);

            return (Storable) method.invoke(null, loc, params, generator);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                throw (AlkException) cause;
            throw new InternalException((Exception) e.getCause());
        }

    }

}
