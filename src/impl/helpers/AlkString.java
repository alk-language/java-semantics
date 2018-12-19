package impl.helpers;

import impl.exceptions.AlkException;

import static impl.exceptions.AlkException.ERR_ADD_STRING;
import static impl.exceptions.AlkException.ERR_SUB_STRING;

public class AlkString extends AlkValue {

    public String value;

    public AlkString(String value) {
        type = "String";
        this.value = value;
    }

    @Override
    public AlkValue add(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_ADD_STRING);
    }

    @Override
    public AlkValue subtract(AlkValue visit) throws AlkException {
        throw new AlkException(ERR_SUB_STRING);
    }

    @Override
    public String toString() {
        return null;
    }
}
