package ro.uaic.info.alk.visitor.interpreter;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.ContextVar;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.EnvironmentProxy;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkStructure;
import ro.uaic.info.alk.util.Pair;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.visitor.interpreter.SmallStepExpressionInterpreter;
import ro.uaic.info.alk.visitor.interpreter.InterpreterHelper;
import ro.uaic.info.alk.visitor.interpreter.RequiresGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BaseExpressionInterpreter
implements SmallStepExpressionInterpreter<ConcreteValue>
{
    private static final Map<String, Method> alkValueOps = new HashMap<>();

    static
    {
        Method[] methods = AlkValue.class.getMethods();
        for (Method method : methods)
        {
            alkValueOps.put(method.getName(), method);
        }
    }

    private final LocationGenerator locationGenerator;
    private Environment env;

    public BaseExpressionInterpreter(Environment env, LocationGenerator locationGenerator)
    {
        this.env = env;
        this.locationGenerator = locationGenerator;
    }

    @Override
    public ConcreteValue evaluate(Operator op, List<ConcreteValue> values)
    {
        String opName = op.toString().toLowerCase();

        try
        {
            Method method = alkValueOps.get(opName);

            if (method == null)
            {
                throw new InternalException("Can't find desired operator for AlkValue through reflection: " + opName);
            }

            if (values.get(0) == null)
            {
                throw new InternalException("First operand is null in this operation: " + opName);
            }

            List<Object> params = new ArrayList<>();
            for (int i = 0; i < values.size(); i++)
            {
                params.add(i, values.get(i).toRValue());
            }

            if (method.getAnnotation(RequiresGenerator.class) != null)
            {
                params.add(locationGenerator);
            }

            if (method.getParameterCount() != params.size() - 1)
            {
                throw new InternalException("Invalid number of operands for operator: " + opName);
            }

            return (ConcreteValue) method.invoke(params.get(0), params.subList(1, params.size()).toArray());
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ConcreteValue evaluateBuiltIn(AlkBuiltInMethod op, ConcreteValue factor, List<ConcreteValue> params)
    {
        // TODO add support
        return null;
    }

    @Override
    public ConcreteValue interpretVariable(String id)
    {
        if (env.has(id))
        {
            return env.getLocation(id);
        }

        throw new AlkException("Undeclared variable: " + id);
    }

    @Override
    public ConcreteValue interpretSymId(String id)
    {
        throw new InternalException("Can't interpret a symbolic value with a base expression interpreter.");
    }

    @Override
    public ConcreteValue interpretContextVar(ContextVar old, String id)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public ConcreteValue interpretPrimitive(Primitive primitive, String value)
    {
        return InterpreterHelper.interpretAsValue(primitive, value);
    }

    @Override
    public ConcreteValue interpretComposite(Primitive primitive, List<ConcreteValue> values)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        if (values == null || values.isEmpty())
        {
            return struct;
        }

        for (ConcreteValue value : values)
        {
            struct.push(value.toRValue(), locationGenerator);
        }

        return struct;
    }

    @Override
    public ConcreteValue interpretCompositeInterval(Primitive primitive, ConcreteValue x, ConcreteValue y)
    {
        Storable left = x.toRValue();
        Storable right = y.toRValue();

        if (!(left instanceof AlkInt) || !(right instanceof AlkInt))
            throw new InternalException("Can't make interval if limits are not integers");

        AlkInt a = (AlkInt) left;
        AlkInt b = (AlkInt) right;

        if (a.greater(b).isTrue())
            throw new InternalException("Can't make interval if left limit is greater than right limit");

        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);

        a = (AlkInt) a.clone(null);
        while (a.lowereq(b).isTrue())
        {
            struct.push(a, locationGenerator);
            a = (AlkInt) a.add(AlkInt.ONE, locationGenerator);
        }

        return struct;
    }

    @Override
    public ConcreteValue interpretCompositeFilterSpec(Primitive primitive,
                                                      String id,
                                                      ConcreteValue x,
                                                      Function<ConcreteValue, Object> suchThat)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        Storable fromExpr = x.toRValue();

        if (!(fromExpr instanceof AlkIterableValue))
            throw new AlkException("First expression in filter specification must be an iterable");

        List<Storable> values = new ArrayList<>();
        for (Storable loc : (AlkIterableValue) fromExpr)
        {
            values.add(loc.toRValue());
        }

        EnvironmentProxy proxy = new EnvironmentProxy(env);
        Environment old = env;
        try
        {
            this.env = proxy;
            for (Storable value : values)
            {
                proxy.addTempEntry(id, value.clone(locationGenerator));
                Storable eval = ((Storable) suchThat.apply(null)).toRValue();

                if (!(eval instanceof AlkBool))
                    throw new AlkException("Second expression in filter specification must be a boolean");

                AlkBool condition = (AlkBool) eval;
                if (condition.isTrue())
                {
                    struct.push(value, locationGenerator);
                }
            }
        }
        finally
        {
            this.env = old;
        }
        return struct;
    }

    @Override
    public ConcreteValue interpretCompositeSelectSpec(Primitive primitive, String id, ConcreteValue x, Function<ConcreteValue, Object> suchThat)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        Storable fromExpr = x.toRValue();

        if (!(fromExpr instanceof AlkIterableValue))
            throw new AlkException("Second expression in select specification must be an iterable");

        List<Storable> values = new ArrayList<>();
        for (Storable value : (AlkIterableValue) fromExpr)
        {
            values.add(value);
        }

        EnvironmentProxy proxy = new EnvironmentProxy(env);
        Environment old = env;
        this.env = proxy;
        for (Storable value : values)
        {
            proxy.addTempEntry(id, value.toRValue().clone(locationGenerator));
            Storable eval = ((Storable) suchThat.apply(null)).toRValue();

            if (!(eval instanceof AlkValue))
                throw new InternalException("Can't use non-alkvalue in composite select spec");

            struct.push(eval, locationGenerator);
        }
        this.env = old;
        return struct;
    }

    @Override
    public ConcreteValue interpretCompositeComponents(Primitive primitive, List<Pair<String, ConcreteValue>> comps)
    {
        if (primitive != Primitive.STRUCTURE)
            throw new InternalException("Can't define non-structure type with components");

        AlkStructure struct = new AlkStructure();

        for (Pair<String, ConcreteValue> pair : comps)
        {
            Storable value = pair.y.toRValue();

            if (!(value instanceof AlkValue))
                throw new InternalException("Can't use non-alkvalue in composite components spec");

            struct.put(new Pair<>(pair.x, locationGenerator.generate(value.toRValue())));
        }

        return struct;
    }
}
