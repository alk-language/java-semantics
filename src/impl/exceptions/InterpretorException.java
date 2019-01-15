package impl.exceptions;

import static impl.constants.Constants.DEBUG;

public class InterpretorException extends Exception {
    public final static String ERR_VALUE_TYPE_UNRECOGNIZED = "The type of the operand is unrecognized.";
    public final static String ERR_HAS = "The data structure does not have has implemented.";

    public InterpretorException(String text)
    {
        super(text);
    }

    public void printException(int line) {
        if (!DEBUG) return;
        System.out.print("Intepretor error at line "+line+": " + getMessage()+'\n');
        printStackTrace();
    }
}
