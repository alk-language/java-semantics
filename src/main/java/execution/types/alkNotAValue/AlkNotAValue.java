package execution.types.alkNotAValue;

import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;


public class AlkNotAValue extends AlkValue
{

    public static final String NO_RETURN = "No value was returned from a called function.";

    private String msg;

    public AlkNotAValue(String msg)
    {
        type = "NAN";
        this.msg = msg;
    }


    @Override
    public AlkValue clone(LocationGenerator generator) {
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

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }
}
