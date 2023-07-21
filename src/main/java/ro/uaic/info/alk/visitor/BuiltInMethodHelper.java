package ro.uaic.info.alk.visitor;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.exeptions.InternalException;

public class BuiltInMethodHelper
{
    public static AlkBuiltInMethod parse(String text)
    {
        return AlkBuiltInMethod.of(text);
    }
}
