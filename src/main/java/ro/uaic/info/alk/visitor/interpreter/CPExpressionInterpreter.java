package ro.uaic.info.alk.visitor.interpreter;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.ContextVar;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.util.Pair;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.interpreter.BaseExpressionInterpreter;
import ro.uaic.info.alk.symbolic.OverdefinedValue;
import ro.uaic.info.alk.symbolic.CPValue;
import ro.uaic.info.alk.symbolic.UndefinedValue;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.visitor.interpreter.SmallStepExpressionInterpreter;
import ro.uaic.info.alk.visitor.interpreter.InterpreterHelper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CPExpressionInterpreter
implements SmallStepExpressionInterpreter<CPValue>
{
    private static final Map<String, Method> alkValueOps = new HashMap<>();
    SmallStepExpressionInterpreter<ConcreteValue> basicInterpreter;

    static
    {
        Method[] methods = AlkValue.class.getMethods();
        for (Method method : methods)
        {
            alkValueOps.put(method.getName(), method);
        }
    }

    private Environment env;
    private final LocationGenerator locationGenerator;

    public CPExpressionInterpreter(Environment env, LocationGenerator locationGenerator)
    {
        this.env = env;
        this.locationGenerator = locationGenerator;
        this.basicInterpreter = new BaseExpressionInterpreter(env, locationGenerator);
    }

    @Override
    public CPValue evaluate(Operator op, List<CPValue> values)
    {
        if (!InterpreterHelper.containsSomeValue(values, OverdefinedValue.class))
            return new OverdefinedValue();

        if (!InterpreterHelper.containsSomeValue(values, UndefinedValue.class))
            return new UndefinedValue();

        return basicInterpreter.evaluate(op, InterpreterHelper.castToBaseValues(values));
    }

    @Override
    public CPValue evaluateBuiltIn(AlkBuiltInMethod op, CPValue factor, List<CPValue> params)
    {
        // TODO add support
        return null;
    }

    @Override
    public CPValue interpretVariable(String id)
    {
        if (!env.has(id))
            return new UndefinedValue();
        return env.getLocation(id);
    }

    @Override
    public CPValue interpretSymId(String id)
    {
        return null;
    }

    @Override
    public CPValue interpretContextVar(ContextVar old, String id)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public CPValue interpretPrimitive(Primitive primitive, String value)
    {
        return basicInterpreter.interpretPrimitive(primitive, value);
    }

    @Override
    public CPValue interpretComposite(Primitive primitive, List<CPValue> values)
    {
        AlkIterableValue struct = InterpreterHelper.getIterableInstance(primitive);
        if (values == null)
        {
            return struct;
        }

        for (CPValue symvalue : values)
        {
            Storable value = symvalue.toRValue();

            if (value instanceof AlkValue)
            {
                struct.push(value, locationGenerator);
            }
            else if (value instanceof UndefinedValue)
            {
                return new UndefinedValue();
            }
            else if (value instanceof OverdefinedValue)
            {
                return new OverdefinedValue();
            }
            else
            {
                throw new InternalException("Unidentified symbolic value type.");
            }
        }

        return struct;
    }

    @Override
    public CPValue interpretCompositeInterval(Primitive primitive, CPValue left, CPValue right)
    {
        Storable lvalue = left.toRValue();
        Storable rvalue = right.toRValue();

        if (lvalue instanceof UndefinedValue || rvalue instanceof UndefinedValue)
            return new UndefinedValue();

        if (lvalue instanceof OverdefinedValue || rvalue instanceof OverdefinedValue)
            return new OverdefinedValue();

        return basicInterpreter.interpretCompositeInterval(primitive, (ConcreteValue) lvalue, (ConcreteValue) rvalue);
    }

    @Override
    public CPValue interpretCompositeFilterSpec(Primitive primitive, String id, CPValue fromExpr, Function<CPValue, Object> suchThat)
    {
        Storable fromValue = fromExpr.toRValue();

        if (fromValue instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromValue instanceof OverdefinedValue)
            return new OverdefinedValue();

        // TODO: provider may return CPValue

        return basicInterpreter.interpretCompositeFilterSpec(primitive, id, (ConcreteValue) fromValue, (request) ->
                (ConcreteValue) suchThat.apply(request));
    }

    @Override
    public CPValue interpretCompositeSelectSpec(Primitive primitive, String id, CPValue fromExpr, Function<CPValue, Object> suchThat)
    {
        Storable fromValue = fromExpr.toRValue();

        if (fromValue instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromValue instanceof OverdefinedValue)
            return new OverdefinedValue();

        // TODO: provider may return CPValue

        return basicInterpreter.interpretCompositeSelectSpec(primitive, id, (ConcreteValue) fromValue, (request) ->
                (ConcreteValue) suchThat.apply(request));
    }

    @Override
    public CPValue interpretCompositeComponents(Primitive primitive, List<Pair<String, CPValue>> comps)
    {
        List<Pair<String, ConcreteValue>> tmp = new ArrayList<>();
        for (Pair<String, CPValue> pair : comps)
        {
            String key = pair.x;
            CPValue cpValue = pair.y;
            Storable value = cpValue.toRValue();

            if (value instanceof UndefinedValue)
                return new UndefinedValue();

            if (value instanceof OverdefinedValue)
                return new OverdefinedValue();

            tmp.add(new Pair<>(key, (ConcreteValue) value));
        }

        return basicInterpreter.interpretCompositeComponents(primitive, tmp);
    }
}
