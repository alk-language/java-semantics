package execution.types.alkNotAValue;

import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;


public class AlkNotAValue extends AlkValue
{

    public static final String NO_VALUE = "Unknown value accessed.";


    @Override
    public AlkValue clone(LocationGenerator generator) {
        return new AlkNotAValue();
    }

    @Override
    public String toString() {
        return "?";
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

    @Override
    public AlkValue toRValue()
    {
        throw new AlkException(NO_VALUE);
    }
}
