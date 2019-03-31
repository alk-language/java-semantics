package impl.types.alkNotAValue;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;


public class AlkNotAValue extends AlkValue implements Cloneable {

    public static final String NO_RETURN = "No value was returned from a called function.";

    private String msg;

    public AlkNotAValue(String msg)
    {
        type = "NAN";
        this.msg = msg;
    }


    @Override
    public AlkValue clone() {
        return new AlkNotAValue(msg);
    }

    @Override
    public String toString() {
        return msg;
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        return new AlkBool(false);
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        return new AlkBool(false);
    }
}
