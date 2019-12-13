package execution.state;

import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.types.AlkValue;
import util.CtxState;
import util.Payload;
import util.exception.InternalException;

import java.lang.reflect.InvocationTargetException;

// TODO: merge the create interfaces
public class StateFactory {

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        Payload payload,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(ctxClass, Payload.class).newInstance(ctx, payload);
            payload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        Payload payload,
                                        Class<?> arg,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    Payload.class,
                    Class.class).newInstance(ctx, payload, arg);
            payload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        Payload payload,
                                        AlkValue arg,
                                        Environment env)
    {
        try {
            Class<? extends ParseTree> ctxClass = ParseTree.class;
            if (stateClass.isAnnotationPresent(CtxState.class))
                ctxClass = stateClass.getAnnotation(CtxState.class).ctxClass();

            ExecutionState state = stateClass.getDeclaredConstructor(
                    ctxClass,
                    Payload.class,
                    AlkValue.class).newInstance(ctx, payload, arg);
            payload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static ExecutionState create(Class<? extends ExecutionState> stateClass,
                                        ParseTree ctx,
                                        Payload payload,
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
                    Payload.class,
                    ParseTree.class,
                    Class.class).newInstance(ctx, payload, arg1, arg2);
            payload.getEnvManager().link(state, env);
            return state;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}
