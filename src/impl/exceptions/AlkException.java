package impl.exceptions;

public class AlkException extends Exception {

    public final static String ERR_LOGICALOR_DATA_STRUCTURE = "A data structure value is not a valid operand in this logical or expression.";
    public final static String ERR_LOGICALOR_INT = "An int value is not a valid operand in this logical or expression.";
    public final static String ERR_LOGICALOR_DOUBLE = "A double value is not a valid operand in this logical or expression.";
    public final static String ERR_LOGICALOR_STRING = "A string value is not a valid operand in this logical or expression.";

    public final static String ERR_LOGICALAND_DATA_STRUCTURE = "A data structure value is not a valid operand in this logical and expression.";
    public final static String ERR_LOGICALAND_INT = "An int value is not a valid operand in this logical and expression.";
    public final static String ERR_LOGICALAND_DOUBLE = "A double value is not a valid operand in this logical and expression.";
    public final static String ERR_LOGICALAND_STRING = "A string value is not a valid operand in this logical and expression.";

    public final static String ERR_EQUAL_DATA_STRUCTURE = "A data structure value is not a valid operand in this equality (==) expression.";
    public final static String ERR_EQUAL_INT = "An int value is not a valid operand in this equality (==) expression.";
    public final static String ERR_EQUAL_DOUBLE = "A double value is not a valid operand in this equality (==) expression.";
    public final static String ERR_EQUAL_STRING = "A string value is not a valid operand in this equality (==) expression.";
    public final static String ERR_EQUAL_BOOL = "A bool value is not a valid operand in this equality (==) expression.";

    public final static String ERR_NOTEQUAL_DATA_STRUCTURE = "A data structure value is not a valid operand in this equality (!=) expression.";
    public final static String ERR_NOTEQUAL_INT = "An int value is not a valid operand in this equality (!=) expression.";
    public final static String ERR_NOTEQUAL_DOUBLE = "A double value is not a valid operand in this equality (!=) expression.";
    public final static String ERR_NOTEQUAL_STRING = "A string value is not a valid operand in this equality (!=) expression.";
    public final static String ERR_NOTEQUAL_BOOL = "A bool value is not a valid operand in this equality (!=) expression.";

    public final static String ERR_LOWEREQ_DATA_STRUCTURE = "A data structure value is not a valid operand in this relational (<=) expression.";
    public final static String ERR_LOWEREQ_INT = "An int value is not a valid operand in this relational (<=) expression.";
    public final static String ERR_LOWEREQ_DOUBLE = "A double value is not a valid operand in this relational (<=) expression.";
    public final static String ERR_LOWEREQ_STRING = "A string value is not a valid operand in this relational (<=) expression.";
    public final static String ERR_LOWEREQ_BOOL = "A bool value is not a valid operand in this relational (<=) expression.";

    public final static String ERR_LOWER_DATA_STRUCTURE = "A data structure value is not a valid operand in this relational (<) expression.";
    public final static String ERR_LOWER_INT = "An int value is not a valid operand in this relational (<) expression.";
    public final static String ERR_LOWER_DOUBLE = "A double value is not a valid operand in this relational (<) expression.";
    public final static String ERR_LOWER_STRING = "A string value is not a valid operand in this relational (<) expression.";
    public final static String ERR_LOWER_BOOL = "A bool value is not a valid operand in this relational (<) expression.";

    public final static String ERR_GREATEREQ_DATA_STRUCTURE = "A data structure value is not a valid operand in this relational (>=) expression.";
    public final static String ERR_GREATEREQ_INT = "An int value is not a valid operand in this relational (>=) expression.";
    public final static String ERR_GREATEREQ_DOUBLE = "A double value is not a valid operand in this relational (>=) expression.";
    public final static String ERR_GREATEREQ_STRING = "A string value is not a valid operand in this relational (>=) expression.";
    public final static String ERR_GREATEREQ_BOOL = "A bool value is not a valid operand in this relational (>=) expression.";

    public final static String ERR_GREATER_DATA_STRUCTURE = "A data structure value is not a valid operand in this relational (>) expression.";
    public final static String ERR_GREATER_INT = "An int value is not a valid operand in this relational (>) expression.";
    public final static String ERR_GREATER_DOUBLE = "A double value is not a valid operand in this relational (>) expression.";
    public final static String ERR_GREATER_STRING = "A string value is not a valid operand in this relational (>) expression.";
    public final static String ERR_GREATER_BOOL = "A bool value is not a valid operand in this relational (>) expression.";


    public final static String ERR_BITWISEXOR_DATA_STRUCTURE = "A data structure value is not a valid operand in this bitwise xor expression.";
    public final static String ERR_BITWISEXOR_DOUBLE = "A double value is not a valid operand in this bitwise xor expression.";
    public final static String ERR_BITWISEXOR_STRING = "A string value is not a valid operand in this bitwise xor expression.";
    public final static String ERR_BITWISEXOR_BOOL = "A bool value is not a valid operand in this bitwise xor expression.";

    public final static String ERR_BITWISEOR_DATA_STRUCTURE = "A data structure value is not a valid operand in a bitwise or expression.";
    public final static String ERR_BITWISEOR_DOUBLE = "A double value is not a valid operand in this bitwise or expression.";
    public final static String ERR_BITWISEOR_STRING = "A string value is not a valid operand in this bitwise or expression.";
    public final static String ERR_BITWISEOR_BOOL = "A bool value is not a valid operand in this bitwise or expression.";

    public final static String ERR_BITWISEAND_DATA_STRUCTURE = "A data structure value is not a valid operand in this bitwise and expression.";
    public final static String ERR_BITWISEAND_DOUBLE = "A double value is not a valid operand in this bitwise and expression.";
    public final static String ERR_BITWISEAND_STRING = "A string value is not a valid operand in this bitwise and expression.";
    public final static String ERR_BITWISEAND_BOOL = "A bool value is not a valid operand in this bitwise and expression.";

    public final static String ERR_SHIFTRIGHT_DATA_STRUCTURE = "A data structure value is not a valid operand in this right shifting expression.";
    public final static String ERR_SHIFTRIGHT_DOUBLE = "A double value is not a valid operand in this right shifting expression.";
    public final static String ERR_SHIFTRIGHT_STRING = "A string value is not a valid operand in this right shifting expression.";
    public final static String ERR_SHIFTRIGHT_BOOL = "A bool value is not a valid operand in this right shifting expression.";

    public final static String ERR_SHIFTLEFT_DATA_STRUCTURE = "A data structure value is not a valid operand in this left shifting expression.";
    public final static String ERR_SHIFTLEFT_DOUBLE = "A double value is not a valid operand in this left shifting expression.";
    public final static String ERR_SHIFTLEFT_STRING = "A string value is not a valid operand in this left shifting expression.";
    public final static String ERR_SHIFTLEFT_BOOL = "A bool value is not a valid operand in this left shifting expression.";

    public final static String ERR_ADD_DATA_STRUCTURE = "A data structure value is not a valid operand in this addition expression.";
    public final static String ERR_ADD_STRING = "A string value is not a valid operand in this addition expression.";
    public final static String ERR_ADD_BOOL = "A bool value is not a valid operand in this addition expression.";

    public final static String ERR_SUB_DATA_STRUCTURE = "A data structure value is not a valid operand in this subtracting expression.";
    public final static String ERR_SUB_STRING = "A string value is not a valid operand in this subtracting expression.";
    public final static String ERR_SUB_BOOL = "A bool value is not a valid operand in this subtracting expression.";

    public final static String ERR_MUL_DATA_STRUCTURE = "A data structure value is not a valid operand in this multiplying expression.";
    public final static String ERR_MUL_STRING = "A string value is not a valid operand in this multiplying expression.";
    public final static String ERR_MUL_BOOL = "A bool value is not a valid operand in this multiplying expression.";

    public final static String ERR_DIV_DATA_STRUCTURE = "A data structure value is not a valid operand in this dividing expression.";
    public final static String ERR_DIV_STRING = "A string value is not a valid operand in this dividing expression.";
    public final static String ERR_DIV_BOOL = "A bool value is not a valid operand in this dividing expression.";

    public final static String ERR_MOD_DATA_STRUCTURE = "A data structure value is not a valid operand in this dividing with a reminder expression.";
    public final static String ERR_MOD_STRING = "A string value is not a valid operand in this dividing with a reminder expression.";
    public final static String ERR_MOD_BOOL = "A bool value is not a valid operand in this dividing with a reminder expression.";
    public final static String ERR_MOD_DOUBLE = "A double value is not a valid operand in this dividing with a reminder expression.";



    public final static String ERR_LOGICALOR = "The values of the operands are not valid in this logical or expression";
    public final static String ERR_LOGICALAND = "The values of the operands are not valid in this logical and expression";

    public final static String ERR_IN = "The values of the operands are not valid in this type of expression (in)";

    public final static String ERR_EQUAL = "The values of the operands are not valid in this relational (==) expression";
    public final static String ERR_LOWEREQ = "The values of the operands are not valid in this relational (<=) expression";
    public final static String ERR_LOWER = "The values of the operands are not valid in this relational (<) expression";
    public final static String ERR_GREATEREQ = "The values of the operands are not valid in this relational (>=) expression";
    public final static String ERR_GREATER = "The values of the operands are not valid in this relational (>) expression";
    public final static String ERR_NOTEQUAL = "The values of the operands are not valid in this relational (!=) expression";

    public final static String ERR_BITWISEOR = "The values of the operands are not valid in this bitwise or expression";
    public final static String ERR_BITWISEXOR = "The values of the operands are not valid in this bitwise xor expression";

    public final static String ERR_BITWISEAND = "The values of the operands are not valid in this bitwise and expression";

    public final static String ERR_SHIFTLEFT = "The values of the operands are not valid in this left shifting expression";
    public final static String ERR_SHIFTRIGHT = "The values of the operands are not valid in this right shifting expression";

    public final static String ERR_ADD = "The values of the operands are not valid in an addition expression";
    public final static String ERR_SUB = "The values of the operands are not valid in this subtracting expression";

    public final static String ERR_MUL = "The values of the operands are not valid in this multiplying expression";
    public final static String ERR_DIV = "The values of the operands are not valid in this dividing expression";
    public final static String ERR_MOD = "The values of the operands are not valid in this dividing with a reminder expression";


    public final static String ERR_STAR = "The value of the operand are not valid in this unary (*) expression";
    public final static String ERR_POSITIVE = "The value of the operand are not valid in this unary (+) expression";
    public final static String ERR_NEGATIVE = "The value of the operand are not valid in this unary (-) expression";
    public final static String ERR_NOT = "The value of the operand is not valid in this unary (!) expression";


    public final static String ERR_LEFT_PLUSPLUS = "The value of the operand is not valid in this prefix (left ++) expression";


    public final static String ERR_BRACKET = "The value of the operand is not valid for accessing elements with brackets.";


    public final static String ERR_SHIFT_TOOBIG = "The right operand is too big for this shifting expression.";
    public final static String ERR_CONDITIONAL_NO_BOOL = "The left most operand in a conditional expression must be a boolean.";


    public final static String ERR_PRINT_PARAM = "The print function must have only one parameter.";
    public final static String ERR_NO_REF = "The reference is invalid.";
    public final static String ERR_IF_NOT_BOOL = "The value of the expression to evaluate in if must be boolean.";
    public final static String ERR_WHILE_NOT_BOOL = "The value of the expression to evaluate in while must be boolean.";
    public final static String ERR_DOWHILE_NOT_BOOL = "The value of the expression to evaluate in do while must be boolean.";
    public final static String ERR_FOR_NOT_BOOL = "The value of the expression to evaluate in for must be boolean.";


    public final static String ERR_NOINT_INTERVAL = "The values of the interval's limits must be integers.";
    public final static String ERR_LIMIT = "The value of the left side must be lower than the value of the right side.";


    public final static String ERR_DATASTRUCTURE_UNDEFINED = "The data structure in the left side must be initialized first.";
    public final static String ERR_NOINT_ARRAY = "The values of array's indexes must be integers.";
    public final static String ERR_ARRAY = "The value of the operand must be an array so that its elements can be accessed.";
    public final static String ERR_ARRAY_OUT_OF_BOUNDS = "The position in the array is out of bounds.";

    public AlkException(String text)
    {
        super(text);
    }

    public void printException(int line) {
        System.out.println("Error at line "+line+": "+getMessage());
    }
}
