package ro.uaic.info.alk.visitor.interpreter;

import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.types.AlkFloat;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.types.AlkString;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.enums.Primitive;

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
                return AlkInt.get(new BigInteger(value));
            case STRING:
                return AlkString.get(value.substring(1, value.length() - 1));
            case FLOAT:
                return AlkFloat.get(new BigDecimal(value, AlkFloat.mc));
            case BOOL:
                return AlkBool.get(value.equals("true"));
            case UNKNOWN:
                return AlkNotAValue.INSTANCE;
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
