package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.util.types.Storable;

public class OutOfBoundsException
extends AlkException
{
    public OutOfBoundsException(Storable value, AlkInt index)
    {
        super("Out of bounds. Trying to access element at index " + index +
              " of " + value + ".");
    }
}
