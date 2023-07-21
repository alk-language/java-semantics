package ro.uaic.info.alk.util;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.exhaustive.NameMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.util.functions.BuiltInMethodAnno;
import ro.uaic.info.alk.util.functions.StatefulMethodAnno;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static ro.uaic.info.alk.exeptions.AlkException.*;

public class Invoker {

    public static Storable invokeMethod(String methodName,
                                        Location loc,
                                        List<Storable> params,
                                        LocationGenerator generator,
                                        FunctionsSolver solver,
                                        AlkExecution exec)
    {
        try
        {
            methodName = NameMapper.processBuiltInName(methodName);
            Method method = solver.solve(methodName);

            if (method.getAnnotation(BuiltInMethodAnno.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated method.");

            boolean valid = false;
            for (int paramNumber : method.getAnnotation(BuiltInMethodAnno.class).paramNumber())
                if (paramNumber == params.size()) {
                    valid = true;
                    break;
                }

            if (!valid)
                throw new AlkException(ERR_PARAM_NUMBER);

            boolean stateful = false;
            if (method.getAnnotation(StatefulMethodAnno.class) != null)
            {
                stateful = true;
            }

            if (stateful)
                return (Storable) method.invoke(null, loc, params, generator, exec);
            else
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
