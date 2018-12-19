package impl.exceptions;

public class InterpretorException extends Exception {
    public final static String ERR_VALUE_TYPE_UNRECOGNIZED = "The type of the operand is unrecognized.";

    public InterpretorException(String text)
    {
        super(text);
    }

    public void printException(int line) {
        System.out.print("Intepretor error at line "+line+": " + getMessage()+'\n');
        printStackTrace();
    }
}
