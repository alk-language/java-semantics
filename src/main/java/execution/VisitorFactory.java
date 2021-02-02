package execution;

import state.Payload;
import grammar.alkBaseVisitor;
import execution.parser.env.Environment;
import util.exception.InternalException;

import java.lang.reflect.InvocationTargetException;

public class VisitorFactory
{

    public static alkBaseVisitor create(Class<? extends alkBaseVisitor> clazz, Environment env, ExecutionPayload executionPayload)
    {
        try
        {
            return clazz.getDeclaredConstructor(Environment.class, ExecutionPayload.class).newInstance(env, executionPayload);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            throw new InternalException("The visitor factory failed!");
        }
    }

    public static alkBaseVisitor create(Class<? extends alkBaseVisitor> clazz, Payload payload, Class<? extends Payload> payloadClass)
    {
        try
        {
            return clazz.getDeclaredConstructor(payloadClass).newInstance(payload);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            throw new InternalException("The visitor factory failed!");
        }
    }

}
