package visitor;

import execution.parser.env.Environment;
import execution.parser.env.Location;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.BaseValue;
import symbolic.OverdefinedValue;
import symbolic.CPValue;
import symbolic.UndefinedValue;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Value;

import javax.xml.ws.Provider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPExpressionInterpreter implements ExpressionInterpreter<CPValue>
{
    private static final Map<String, Method> alkValueOps = new HashMap<>();
    ExpressionInterpreter<BaseValue> basicInterpreter;

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
        this.basicInterpreter = new BasicExpressionInterpreter(env, locationGenerator);
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
    public CPValue interpretVariable(String id)
    {
        if (!env.has(id))
            return new UndefinedValue();
        return env.getLocation(id);
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
            Value value = symvalue.toRValue();

            if (value instanceof AlkValue)
            {
                struct.push(locationGenerator.generate(value));
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
        Value lvalue = left.toRValue();
        Value rvalue = right.toRValue();

        if (lvalue instanceof UndefinedValue || rvalue instanceof UndefinedValue)
            return new UndefinedValue();

        if (lvalue instanceof OverdefinedValue || rvalue instanceof OverdefinedValue)
            return new OverdefinedValue();

        return basicInterpreter.interpretCompositeInterval(primitive, (BaseValue) lvalue, (BaseValue) rvalue);
    }

    @Override
    public CPValue interpretCompositeFilterSpec(Primitive primitive, String id, CPValue fromExpr, Provider<CPValue> suchThat)
    {
        Value fromValue = fromExpr.toRValue();

        if (fromValue instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromValue instanceof OverdefinedValue)
            return new OverdefinedValue();

        // TODO: provider may return CPValue

        return basicInterpreter.interpretCompositeFilterSpec(primitive, id, (BaseValue) fromValue, (request) ->
                (BaseValue) suchThat.invoke(request));
    }

    @Override
    public CPValue interpretCompositeSelectSpec(Primitive primitive, String id, CPValue fromExpr, Provider<CPValue> suchThat)
    {
        Value fromValue = fromExpr.toRValue();

        if (fromValue instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromValue instanceof OverdefinedValue)
            return new OverdefinedValue();

        // TODO: provider may return CPValue

        return basicInterpreter.interpretCompositeSelectSpec(primitive, id, (BaseValue) fromValue, (request) ->
                (BaseValue) suchThat.invoke(request));
    }

    @Override
    public CPValue interpretCompositeComponents(Primitive primitive, List<Pair<String, CPValue>> comps)
    {
        List<Pair<String, BaseValue>> tmp = new ArrayList<>();
        for (Pair<String, CPValue> pair : comps)
        {
            String key = pair.x;
            CPValue cpValue = pair.y;
            Value value = cpValue.toRValue();

            if (value instanceof UndefinedValue)
                return new UndefinedValue();

            if (value instanceof OverdefinedValue)
                return new OverdefinedValue();

            tmp.add(new Pair<>(key, (BaseValue) value));
        }

        return basicInterpreter.interpretCompositeComponents(primitive, tmp);
    }
}
