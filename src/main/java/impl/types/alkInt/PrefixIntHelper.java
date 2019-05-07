package impl.types.alkInt;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;

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
