package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.util.types.Storable;

public class DivisionByZeroException
extends AlkException
{
    public DivisionByZeroException(Operator op, Storable value)
    {
        super("Division by zero! Can't use \"" + op.getSyntax() + "\" operator with " + value + " and 0.");
    }
}
