package execution.types.alkInt;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;

import java.math.BigInteger;

public class PrefixIntHelper {
    private BigInteger value;

    PrefixIntHelper(BigInteger value)
    {
        this.value = value;
    }

    AlkValue plusplusleft() throws AlkException, InterpretorException
    {
        return new AlkInt(value);
    }

    AlkValue minusminusleft() throws AlkException, InterpretorException
    {
        return new AlkInt(value);
    }
}
