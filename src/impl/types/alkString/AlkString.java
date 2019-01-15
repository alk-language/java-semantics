package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;

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


    public AlkValue lowereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.lowereq(operand);
    }


    public AlkValue lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.lower(operand);
    }

    public AlkValue greatereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.greatereq(operand);
    }


    public AlkValue greater(AlkValue operand) throws AlkException, InterpretorException {
        RelationalStringHelper help = new RelationalStringHelper(value);
        return help.greater(operand);
    }

    @Override
    public String toString() {
        return value;
    }
}
