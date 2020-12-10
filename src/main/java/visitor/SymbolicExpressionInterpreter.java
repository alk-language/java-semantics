package visitor;

import execution.parser.env.Environment;
import execution.parser.env.EnvironmentProxy;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import execution.types.alkString.AlkString;
import execution.types.alkStructure.AlkStructure;
import symbolic.OverdefinedValue;
import symbolic.SymbolicValue;
import symbolic.UndefinedValue;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.ComponentValue;
import util.types.Value;

import javax.xml.ws.Provider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolicExpressionInterpreter implements ExpressionInterpreter<SymbolicValue>
{
    private static Map<String, Method> alkValueOps = new HashMap<>();

    static {
        Method[] methods = AlkValue.class.getMethods();
        for (Method method : methods)
        {
            alkValueOps.put(method.getName(), method);
        }
    }

    private Environment env;
    private LocationGenerator locationGenerator;

    public SymbolicExpressionInterpreter(Environment env, LocationGenerator locationGenerator)
    {
        this.env = env;
        this.locationGenerator = locationGenerator;
    }

    @Override
    public SymbolicValue evaluate(Operator op, List<SymbolicValue> values)
    {

        for (SymbolicValue value : values)
            if (value instanceof OverdefinedValue)
                return new OverdefinedValue();

        for (SymbolicValue value : values)
            if (value instanceof UndefinedValue)
                return new UndefinedValue();

        String opName = op.toString().toLowerCase();

        try
        {
            Method method = alkValueOps.get(opName);

            if (method == null)
            {
                throw new InternalException("Can't find desired operator for AlkValue through reflection");
            }

            if (values.get(0) == null)
            {
                throw new InternalException("First symbolic operand is null.");
            }

            Class<?>[] paramTypes = method.getParameterTypes();
            if (paramTypes.length != values.size() - 1)
            {
                throw new InternalException("Invalid number of parameters for operator: " + opName);
            }

            List<Value> params = new ArrayList<>();
            for (int i=0; i<values.size(); i++)
                params.add(i, values.get(i).toRValue());

            return (SymbolicValue) method.invoke(params.get(0), params.subList(1, params.size()).toArray());
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public SymbolicValue interpretVariable(String id)
    {
        if (!env.has(id))
            return new UndefinedValue();
        return env.getLocation(id);
    }

    @Override
    public SymbolicValue interpretPrimitive(Primitive primitive, String value)
    {
        switch (primitive)
        {
            case INT:
                return new AlkInt(new BigInteger(value));
            case STRING:
                return new AlkString(value.substring(1, value.length() - 1));
            case FLOAT:
                return new AlkFloat(new BigDecimal(value));
            case BOOL:
                return new AlkBool(value.equals("true"));
            default:
                throw new InternalException("Unrecognized primitive in Symbolic Expression Interpreter");
        }
    }

    private AlkIterableValue getIterableInstance(Primitive primitive)
    {
        AlkIterableValue struct;
        switch (primitive)
        {
            case ARRAY:
                struct = new AlkArray();
                break;
            case SET:
                struct = new AlkSet();
                break;
            case LIST:
                struct = new AlkList();
                break;
            default:
                throw new InternalException("Unidentified iterable alk value type.");
        }
        return struct;
    }

    @Override
    public SymbolicValue interpretComposite(Primitive primitive, List<SymbolicValue> values)
    {
        AlkIterableValue struct = getIterableInstance(primitive);
        if (values == null)
        {
            return struct;
        }

        for (SymbolicValue symvalue : values)
        {
            Value value = symvalue;
            if (symvalue instanceof Location)
            {
                value = symvalue.toRValue();
            }

            if (value instanceof AlkValue)
            {
                Location loc = locationGenerator.generate(((AlkValue) value).toRValue());
                struct.push(loc);
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
    public SymbolicValue interpretCompositeInterval(Primitive primitive, SymbolicValue x, SymbolicValue y)
    {
        Value left = x.toRValue();
        Value right = y.toRValue();

        if (left instanceof UndefinedValue || right instanceof UndefinedValue)
            return new UndefinedValue();

        if (left instanceof OverdefinedValue || right instanceof OverdefinedValue)
            return new OverdefinedValue();

        if (!(left instanceof AlkInt) || !(right instanceof AlkInt))
            throw new InternalException("Can't make interval if limits are not integers");

        AlkInt a = ((AlkInt) left);
        AlkInt b = (AlkInt) right;

        if (a.greater(b).isTrue())
            throw new InternalException("Can't make interval if left limit is greater than right limit");

        AlkIterableValue struct = getIterableInstance(primitive);

        a = (AlkInt) a.clone(null);
        while (a.lowereq(b).isTrue())
        {
            Location loc = locationGenerator.generate(a);
            struct.push(loc);
            a = (AlkInt) a.add(new AlkInt(BigInteger.ONE));
        }

        return struct;
    }

    @Override
    public SymbolicValue interpretCompositeFilterSpec(Primitive primitive, String id, SymbolicValue x, Provider<SymbolicValue> suchThat)
    {
        AlkIterableValue struct = getIterableInstance(primitive);
        Value fromExpr = x.toRValue();

        if (fromExpr instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromExpr instanceof OverdefinedValue)
            return new OverdefinedValue();

        if (!(fromExpr instanceof AlkIterableValue))
            throw new AlkException("First expression in filter specification must be an iterable");

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
            Value eval = suchThat.invoke(null).toRValue();

            if (eval instanceof UndefinedValue)
                return new UndefinedValue();

            if (eval instanceof OverdefinedValue)
                return new OverdefinedValue();

            if (!(eval instanceof AlkBool))
                throw new AlkException("Second expression in filter specification must be a boolean");

            AlkBool condition = (AlkBool) eval;
            if (condition.isTrue())
            {
                struct.push(locationGenerator.generate(loc.toRValue().clone(locationGenerator)));
            }
        }
        this.env = old;
        return struct;
    }

    @Override
    public SymbolicValue interpretCompositeSelectSpec(Primitive primitive, String id, SymbolicValue x, Provider<SymbolicValue> suchThat)
    {
        AlkIterableValue struct = getIterableInstance(primitive);
        Value fromExpr = x.toRValue();

        if (fromExpr instanceof UndefinedValue)
            return new UndefinedValue();

        if (fromExpr instanceof OverdefinedValue)
            return new OverdefinedValue();

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
            Value eval = suchThat.invoke(null).toRValue();

            if (eval instanceof UndefinedValue)
                return new UndefinedValue();

            if (eval instanceof OverdefinedValue)
                return new OverdefinedValue();

            if (!(eval instanceof AlkValue))
                throw new InternalException("Can't use non-alkvalue in composite select spec");

            struct.push(locationGenerator.generate(eval.clone(locationGenerator)));
        }
        this.env = old;
        return struct;
    }

    @Override
    public SymbolicValue interpretCompositeComponents(Primitive primitive, List<Pair<String, SymbolicValue>> comps)
    {
        if (primitive != Primitive.STRUCTURE)
            throw new InternalException("Can't define non-structure type with components");

        AlkStructure struct = new AlkStructure();

        for (Pair<String, SymbolicValue> pair : comps)
        {
            Value value = pair.y.toRValue();
            if (value instanceof UndefinedValue)
                return new UndefinedValue();

            if (value instanceof OverdefinedValue)
                return new OverdefinedValue();

            if (!(value instanceof AlkValue))
                throw new InternalException("Can't use non-alkvalue in composite components spec");

            struct.insert(new ComponentValue(pair.x, locationGenerator.generate(value.clone(locationGenerator))));
        }

        return struct;
    }
}
