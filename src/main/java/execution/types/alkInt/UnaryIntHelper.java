package execution.types.alkInt;

import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.InterpretorException;
import execution.types.AlkValue;

import java.math.BigInteger;

public class UnaryIntHelper {
    private BigInteger value;

    UnaryIntHelper(BigInteger value)
    {
        this.value = value;
    }

    AlkValue positive() throws AlkException, InterpretorException
    {
        return new AlkInt(value);
    }

    AlkValue negative() throws AlkException, InterpretorException
    {
        return new AlkInt(value.negate());
    }
}
