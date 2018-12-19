package impl.helpers;

import impl.exceptions.AlkException;

import static impl.exceptions.AlkException.ERR_ADD_BOOL;
import static impl.exceptions.AlkException.ERR_SUB_BOOL;

public class AlkBool extends AlkValue {

    public Boolean value;

    public AlkBool(boolean value) {
        type = "Bool";
        this.value = value;
    }

    @Override
    public AlkValue add(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_ADD_BOOL);
    }

    @Override
    public AlkValue subtract(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_SUB_BOOL);
    }

    @Override
    public String toString() {
        return null;
    }
}
