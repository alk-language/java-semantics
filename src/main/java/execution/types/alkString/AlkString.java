package execution.types.alkString;

import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import execution.types.AlkComparable;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import static parser.exceptions.AlkException.*;

public class AlkString extends AlkValue implements AlkComparable<AlkString>
{

    private String value;

    public AlkString(String value) {
        type = "String";
        this.value = value;
    }

    @Deprecated
    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!(operand instanceof AlkString))
            throw new AlkException(ERR_EQUAL_STRING);
        return equal((AlkString)operand);
    }

    @Deprecated
    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!(operand instanceof AlkString))
            throw new AlkException(ERR_EQUAL_STRING);
        return lower((AlkString)operand);
    }

    private AlkValue at(AlkInt index)
    {
        try
        {
            int position = index.value.intValueExact();
            if (position < 0 || value.length() <= position)
                throw new AlkException(ERR_STRING_OUT_OF_BOUNDS);
            return new AlkString(String.valueOf(value.charAt(position)));
        }
        catch (ArithmeticException e)
        {
            // TODO: maybe replace with InternalException wrapper?
            throw new AlkException(ERR_AT_TOOBIG);
        }
    }

    public AlkValue split(AlkString pattern, LocationGenerator generator) throws AlkException
    {
        String[] strings = value.split(pattern.value);
        AlkArray arr = new AlkArray();
        for (String string : strings)
            arr.push(generator.generate(new AlkString(string)));
        return arr;
    }

    @Override
    public AlkValue split()
    {
        return split(new AlkString(""));
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }

    public AlkValue insert(AlkInt position, AlkString str)
    {
        try
        {
            int index = position.value.intValueExact();
            if (index < 0 || value.length() < index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            value = value.substring(0, index) + str + value.substring(index);
            return this;
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_INSERT_TOOBIG);
        }
    }

    public AlkValue update(AlkInt position, AlkString str)
    {
        try
        {
            int index = position.value.intValueExact();
            if (index < 0 || value.length() <= index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            // TODO: let update with multiple char string, or show only WARNING and take first character
            if (str.value.length() != 1)
                throw new AlkException(ERR_ONLY_CHAR);
            value = value.substring(0, index) + str + value.substring(index + 1);
            return this;
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_UPDATE_TOOBIG);
        }
    }


    public AlkValue remove(AlkInt position)
    {
        try
        {
            int index = position.value.intValueExact();
            if (index<0 || this.value.length()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            this.value = this.value.substring(0, index) + this.value.substring(index+1);
            return this;
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_UPDATE_TOOBIG);
        }
    }


    @Override
    public AlkInt size()
    {
        return new AlkInt(value.length());
    }


    public AlkInt len()
    {
        return new AlkInt(value.length());
    }

    @Override
    public AlkString add(AlkValue operand)
    {
        if (!operand.type.equals("String"))
            throw new AlkException(AlkException.ERR_ADD_STRING);
        return new AlkString(value + ((AlkString)operand).value);
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        String copy = value;
        return new AlkString(copy);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public AlkBool equal(AlkString operand)
    {
        return new AlkBool(value.equals(operand.value));
    }

    @Override
    public AlkBool lower(AlkString operand)
    {
        return new AlkBool(value.compareTo(operand.value) < 0);
    }
}
