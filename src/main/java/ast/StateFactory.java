package ast;

import control.parser.CFGPayload;
import control.parser.CFGState;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.env.Environment;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.ExecutionPayload;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

// TODO: merge the create interfaces
public class StateFactory
{
    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                 ParseTree ctx,
                                 ExecutionPayload executionPayload,
                                 Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(ctxClass, ExecutionPayload.class).newInstance(ctx, executionPayload);
            executionPayload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            handle(e);
        }
        return null;
    }

    private static void handle(InvocationTargetException e) {
        if (e.getTargetException() instanceof RuntimeException)
            throw (RuntimeException) e.getTargetException();
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        ExecutionPayload executionPayload,
                                        Class<?> arg,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    ExecutionPayload.class,
                    Class.class).newInstance(ctx, executionPayload, arg);
            executionPayload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            throw new AlkException(e.getTargetException().getMessage());
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        ExecutionPayload executionPayload,
                                        AlkValue arg,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    ExecutionPayload.class,
                    AlkValue.class).newInstance(ctx, executionPayload, arg);
            executionPayload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            throw new AlkException(e.getTargetException().getMessage());
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        ExecutionPayload executionPayload,
                                        List list,
                                        Class<?> clazz,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    ExecutionPayload.class,
                    List.class,
                    Class.class).newInstance(ctx, executionPayload, list, clazz);
            executionPayload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            throw new AlkException(e.getTargetException().getMessage());
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        ExecutionPayload executionPayload,
                                        ParseTree arg1,
                                        Class<?> arg2,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    ExecutionPayload.class,
                    ParseTree.class,
                    Class.class).newInstance(ctx, executionPayload, arg1, arg2);
            executionPayload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            throw new AlkException(e.getTargetException().getMessage());
        }
        return null;
    }

    public static CFGState create(Class<? extends CFGState> stateClass,  ParseTree ctx, CFGPayload payload)
    {
        try
        {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
            {
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();
            }

            CFGState state = stateClass.getDeclaredConstructor(ctxClass, CFGPayload.class).newInstance(ctx, payload);
            return state;
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            handle(e);
        }
        return null;
    }
}
