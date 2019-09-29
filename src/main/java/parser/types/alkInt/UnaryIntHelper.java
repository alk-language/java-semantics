package parser.types.alkInt;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.AlkValue;

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
