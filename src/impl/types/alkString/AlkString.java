package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;

public class AlkString extends AlkValue {

    public String value;

    public AlkString(String value) {
        type = "String";
        this.value = value;
    }

    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityStringHelper help = new EqualityStringHelper(value);
        return help.equal(operand);
    }
    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityStringHelper help = new EqualityStringHelper(value);
        return help.notequal(operand);
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
    public AlkValue clone() {
        return new AlkString(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
