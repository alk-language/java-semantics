package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.util.types.Storable;

public class InvalidLeftValueException
extends AlkException
{
    public InvalidLeftValueException(Storable value)
    {
        super("Invalid location! The value " + value + " was encountered, but a location was expected.");
    }
}
