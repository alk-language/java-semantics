package execution.types.alkString;

import ast.AST;
import ast.expr.StringAST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.types.AlkComparable;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import static execution.parser.exceptions.AlkException.*;


// TODO: Make strings methods accessible even if they are not at stored
public class AlkString
extends AlkValue
implements AlkComparable<AlkString>
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

    @Override
    public Location at(AlkValue index, LocationGenerator generator)
    {
        if (!(index instanceof AlkInt))
            throw new AlkException("First operator of at should be an integer.");
        try
        {
            int position = ((AlkInt)index).value.intValueExact();
            if (position < 0 || value.length() <= position)
                throw new AlkException(ERR_STRING_OUT_OF_BOUNDS);
            return generator.generate(new AlkString(String.valueOf(value.charAt(position))));
        }
        catch (ArithmeticException e)
        {
            // TODO: maybe replace with InternalException wrapper?
            throw new AlkException(ERR_AT_TOOBIG);
        }
    }

    @Override
    public Location split(AlkValue pattern, LocationGenerator generator) throws AlkException
    {
        if (!(pattern instanceof AlkString))
            throw new AlkException("Need to use string as split pattern.");

        String[] strings = value.split(((AlkString)pattern).value);
        AlkArray arr = new AlkArray();
        for (String string : strings)
            arr.push(generator.generate(new AlkString(string)));
        return generator.generate(arr);
    }

    @Override
    public Location split(LocationGenerator generator)
    {
        return split(new AlkString(""), generator);
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }

    @Override
    public AlkValue insert(AlkValue position, Location str)
    {
        if (!(position instanceof AlkInt))
            throw new AlkException("Can't insert at non-integer position.");

        if (!(str.toRValue() instanceof AlkString))
            throw new AlkException("Can't insert a non-string value.");

        try
        {
            int index = ((AlkInt)position).value.intValueExact();
            if (index < 0 || value.length() < index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            value = value.substring(0, index) + str.toRValue() + value.substring(index);
            return this;
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_INSERT_TOOBIG);
        }
    }

    @Override
    public AlkValue update(AlkValue position, Location str)
    {
        if (!(position instanceof AlkInt))
            throw new AlkException("Can't update at non-integer position.");

        if (!(str.toRValue() instanceof AlkString))
            throw new AlkException("Can't update with a non-string value.");

        try
        {
            String val = ((AlkString) str.toRValue()).value;
            int index = ((AlkInt) position).value.intValueExact();
            if (index < 0 || value.length() <= index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            // TODO: let update with multiple char string, or show only WARNING and take first character
            if (val.length() != 1)
                throw new AlkException(ERR_ONLY_CHAR);
            value = value.substring(0, index) + str.toRValue() + value.substring(index + 1);
            return this;
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_UPDATE_TOOBIG);
        }
    }

    @Override
    public AlkValue remove(AlkValue position)
    {
        if (!(position instanceof AlkInt))
            throw new AlkException("Can't remove at non-integer position.");

        try
        {
            int index = ((AlkInt)position).value.intValueExact();
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

    @Override
    public AlkString add(AlkValue operand, LocationGenerator generator)
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
        return "\"" + value + "\"";
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

    @Override
    public AST toAST()
    {
        return new StringAST(value);
    }

    @Override
    public boolean isFullConcrete()
    {
        return true;
    }
}
