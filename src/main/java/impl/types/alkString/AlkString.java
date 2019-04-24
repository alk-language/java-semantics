package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;

import static impl.exceptions.AlkException.*;

public class AlkString extends AlkValue implements Cloneable{

    public String value;

    public AlkString(String value) {
        type = "String";
        this.value = value;
    }

    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityStringHelper help = new EqualityStringHelper(value);
        return help.equal(operand);
    }


    public AlkBool lowereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.lowereq(operand);
    }


    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.lower(operand);
    }

    public AlkBool greatereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.greatereq(operand);
    }


    public AlkBool greater(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.greater(operand);
    }

    @Override
    public AlkValue at(AlkValue index) throws AlkException {
        if (!index.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int position = ((AlkInt)index).value.intValueExact();
            if (position<0 || value.length()<=position)
                throw new AlkException(ERR_STRING_OUT_OF_BOUNDS);
            return new AlkString(String.valueOf(value.charAt(position)));
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_AT_TOOBIG);
        }

    }

    @Override
    public AlkValue split(AlkValue pattern) throws AlkException {
        if (!pattern.type.equals("String"))
            throw new AlkException(ERR_PARAM);
        String[] strs = value.split(((AlkString)pattern).value);
        AlkArray arr = new AlkArray();
        for (int i=0; i<strs.length; i++)
            arr.push(new AlkString(strs[i]));
        return arr;
    }

    @Override
    public AlkValue split(){
        String[] strs = value.split("");
        AlkArray arr = new AlkArray();
        for (int i=0; i<strs.length; i++)
            arr.push(new AlkString(strs[i]));
        return arr;
    }


    @Override
    public AlkValue insert(AlkValue position, AlkValue value) throws AlkException {
        if (!position.type.equals("Int") || !value.type.equals("String"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || this.value.length()<index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            this.value = this.value.substring(0, index) + value + this.value.substring(index);
            return this;
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_INSERT_TOOBIG);
        }
    }

    @Override
    public AlkValue update(AlkValue position, AlkValue value) throws AlkException {
        if (!position.type.equals("Int") || !value.type.equals("String"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || this.value.length()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            String tba = ((AlkString) value).value;
            if (tba.length()!=1)
                throw new AlkException(ERR_ONLY_CHAR);
            this.value = this.value.substring(0, index) + value + this.value.substring(index+1);
            return this;
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_UPDATE_TOOBIG);
        }
    }

    @Override
    public AlkValue remove(AlkValue position) throws AlkException {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
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


    public AlkInt len() throws AlkException {
        return new AlkInt(value.length());
    }

    @Override
    public AlkString add(AlkValue operand) throws AlkException {
        if (!operand.type.equals("String"))
            throw new AlkException(AlkException.ERR_ADD_STRING);
        return new AlkString(value + ((AlkString)operand).value);
    }

    @Override
    public AlkValue clone() {
        String copy = value;
        return new AlkString(copy);
    }

    @Override
    public String toString() {
        return value;
    }
}
