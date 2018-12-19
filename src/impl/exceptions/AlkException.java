package impl.exceptions;

public class AlkException extends Exception {

    public final static String ERR_ADD_DATA_STRUCTURE = "A data structure value is not a valid operand in an addition expression.";
    public final static String ERR_ADD_STRING = "A string value is not a valid operand in an addition expression.";
    public final static String ERR_ADD_BOOL = "A bool value is not a valid operand in an addition expression.";
    public final static String ERR_SUB_STRING = "A string value is not a valid operand in a subtracting expression.";
    public final static String ERR_SUB_BOOL = "A bool value is not a valid operand in a subtracting expression.";
    public final static String ERR_VALUE_TYPE_UNRECOGNIZED = "[Interpretor] The type of the operand is unrecognized.";

    public AlkException(String text)
    {
        super(text);
    }

    public void printException(int line) {
        System.out.print("Error at line "+line+": "+getMessage()+"\n");
    }
}
