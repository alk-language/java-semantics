package visitor.interpreter.base;

import ast.enums.BuiltInMethod;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentProxy;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.ConcreteValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import execution.types.alkStructure.AlkStructure;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Storable;
import ast.enums.Operator;
import ast.enums.Primitive;
import visitor.interpreter.SmallStepExpressionInterpreter;
import visitor.interpreter.InterpreterHelper;
import visitor.interpreter.RequiresGenerator;

import javax.xml.ws.Provider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ConcreteValue evaluateBuiltIn(BuiltInMethod op, ConcreteValue factor, List<ConcreteValue> params)
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
            struct.push(locationGenerator.generate(value.toRValue()));
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
            struct.push(locationGenerator.generate(a));
            a = (AlkInt) a.add(AlkInt.ONE, locationGenerator);
        }

        return struct;
    }

    @Override
    public ConcreteValue interpretCompositeFilterSpec(Primitive primitive,
                                                      String id,
                                                      ConcreteValue x,
                                                      Provider<ConcreteValue> suchThat)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        Storable fromExpr = x.toRValue();

        if (!(fromExpr instanceof AlkIterableValue))
            throw new AlkException("First expression in filter specification must be an iterable");

        List<Location> locs = new ArrayList<>();
        for (Location loc : (AlkIterableValue) fromExpr)
        {
            locs.add(loc);
        }

        EnvironmentProxy proxy = new EnvironmentProxy(env);
        Environment old = env;
        try
        {
            this.env = proxy;
            for (Location loc : locs)
            {
                proxy.addTempEntry(id, loc.toRValue().clone(locationGenerator));
                Storable eval = suchThat.invoke(null).toRValue();

                if (!(eval instanceof AlkBool))
                    throw new AlkException("Second expression in filter specification must be a boolean");

                AlkBool condition = (AlkBool) eval;
                if (condition.isTrue())
                {
                    struct.push(locationGenerator.generate(loc.toRValue().clone(locationGenerator)));
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
    public ConcreteValue interpretCompositeSelectSpec(Primitive primitive, String id, ConcreteValue x, Provider<ConcreteValue> suchThat)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        Storable fromExpr = x.toRValue();

        if (!(fromExpr instanceof AlkIterableValue))
            throw new AlkException("Second expression in select specification must be an iterable");

        List<Location> locs = new ArrayList<>();
        for (Location loc : (AlkIterableValue) fromExpr)
        {
            locs.add(loc);
        }

        EnvironmentProxy proxy = new EnvironmentProxy(env);
        Environment old = env;
        this.env = proxy;
        for (Location loc : locs)
        {
            proxy.addTempEntry(id, loc.toRValue().clone(locationGenerator));
            Storable eval = suchThat.invoke(null).toRValue();

            if (!(eval instanceof AlkValue))
                throw new InternalException("Can't use non-alkvalue in composite select spec");

            struct.push(locationGenerator.generate(eval.clone(locationGenerator)));
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
