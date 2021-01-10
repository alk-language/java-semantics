package util;

import execution.types.AlkValue;
import symbolic.OverdefinedValue;
import symbolic.CPValue;
import symbolic.UndefinedValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Expression
{
    /*
        SymbolicValue = {AlkValue, Undefined, Overdefined}
     */
    static CPValue operation(BinaryOperator op, CPValue parameter1, CPValue parameter2)
    {
        if (parameter1 instanceof OverdefinedValue || parameter2 instanceof OverdefinedValue)
            return new OverdefinedValue();

        if (parameter1 instanceof UndefinedValue || parameter2 instanceof UndefinedValue)
            return new UndefinedValue();

        String opName = op.getName();
        AlkValue value1 = (AlkValue) parameter1;
        AlkValue value2 = (AlkValue) parameter2;

        try
        {
            Method method = value1.getClass().getMethod(opName, AlkValue.class);
            return (CPValue) method.invoke(value1, value2);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}

class BinaryOperator
{

    public String getName()
    {
        return "add";
    }
}