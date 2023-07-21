package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.TypeName;

public class EmptyValueException
extends AlkException
{
    public EmptyValueException(Class<? extends AlkValue> clazz)
    {
        super("Value" + (clazz.isAnnotationPresent(TypeName.class) ?
        " of type " + clazz.getAnnotation(TypeName.class).value() : "") + " is empty.");
    }
}
