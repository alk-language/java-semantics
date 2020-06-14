package util;

import grammar.alkBaseVisitor;
import parser.env.Environment;
import parser.env.EnvironmentImpl;
import util.exception.InternalException;

import java.lang.reflect.InvocationTargetException;

public class VisitorFactory
{

    public static alkBaseVisitor create(Class<? extends alkBaseVisitor> clazz, Environment env, Payload payload)
    {
        try
        {
            return clazz.getDeclaredConstructor(Environment.class, Payload.class).newInstance(env, payload);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            throw new InternalException("The visitor factory failed!");
        }
    }

}
