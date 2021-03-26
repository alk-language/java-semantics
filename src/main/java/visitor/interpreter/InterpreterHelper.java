package visitor.interpreter;

import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.ConcreteValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import execution.types.alkString.AlkString;
import util.exception.InternalException;
import ast.enums.Primitive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InterpreterHelper {

    public static AlkValue interpretAsValue(Primitive primitive, String value)
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

    public static List<ConcreteValue> castToBaseValues(List<?> values)
    {
        List<ConcreteValue> result = new ArrayList<>();
        for (Object value : values)
        {
            if (!(value instanceof ConcreteValue))
                throw new InternalException("Can't cast the current value to AlkValue");
            result.add((ConcreteValue) value);
        }
        return result;
    }

    public static boolean containsSomeValue(List<?> values, Class<?> clazz)
    {
        for (Object value : values)
        {
            if (clazz.isAssignableFrom(value.getClass()))
                return true;
        }
        return false;
    }

    public static AlkIterableValue getIterableInstance(Primitive primitive)
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
}
