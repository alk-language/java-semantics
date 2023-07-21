package ro.uaic.info.alk.types;

import ro.uaic.info.alk.exeptions.OutOfBoundsException;
import ro.uaic.info.alk.exeptions.ErrorHandler;

public abstract class AlkIndexedValue
extends AlkIterableValue
{
    protected int getValidIndex(AlkInt operand)
    {
        return getValidIndex(operand, false);
    }

    protected int getValidIndex(AlkInt operand, boolean endInclusive)
    throws OutOfBoundsException
    {
        int index = operand.intValue((e) -> {
            throw new OutOfBoundsException(this, operand);
        });

        int size = ((AlkInt) size()).intValue(ErrorHandler.TO_INTERNAL);
        if (index < 0 || (endInclusive ? index > size : index >= size))
        {
            throw new OutOfBoundsException(this, operand);
        }

        return index;
    }
}
