package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;

public class AlkString extends AlkValue {

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
        return new AlkString(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
