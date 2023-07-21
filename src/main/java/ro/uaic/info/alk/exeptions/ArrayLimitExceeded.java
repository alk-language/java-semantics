package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.types.AlkArray;

import static ro.uaic.info.alk.io.AlkConsole.sizeOption;

public class ArrayLimitExceeded
extends AlkException
{
    public ArrayLimitExceeded()
    {
        super("The array limit of " + AlkArray.MAX_ARRAY + " was exceeded!");
    }

    public String getHints()
    {
        return "Consider increasing the maximum array size using the -" + sizeOption.getOpt() + " option.";
    }
}
