package execution.parser.exceptions;

import util.exception.InternalException;

public class AlkException extends InternalException
{

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
    public final static String ERR_EQUAL_ARR = "The array can be a value in an equality (==) expresion only if the second operand is an array.";
    public final static String ERR_EQUAL_LIST = "The list can be a value in an equality (==) expresion only if the second operand is a list.";
    public final static String ERR_EQUAL_SET = "The set can be a value in an equality (==) expresion only if the second operand is a set.";
    public final static String ERR_EQUAL_STRUCT = "The structure can be a value in an equality (==) expresion only if the second operand is a structure.";

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
    public final static String ERR_LOWER_BOOL = "The bool can be a value in a relational (<) expresion only if the second operand is an bool.";
    public final static String ERR_LOWER_ARR  = "The array can be a value in a relational (<) expresion only if the second operand is an array.";
    public final static String ERR_LOWER_LIST  = "The list can be a value in a relational (<) expresion only if the second operand is an list.";
    public final static String ERR_LOWER_SET = "The set can be a value in a relational (<) expresion only if the second operand is an set.";
    public final static String ERR_LOWER_STRUCT = "The structure can be a value in a relational (<) expresion only if the second operand is an structure.";
    public final static String ERR_LOWER_ITERATOR = "The iterator can be a value in a relational (<) expresion only if the second operand is an iterator.";

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

    public final static String ERR_UNION_NO_SET = "A non-set value is not a valid operand in this union expression.";
    public final static String ERR_INTERSECT_NO_SET = "A non-set value is not a valid operand in this intersecting expression.";
    public final static String ERR_SET_SUBTRACT_NO_SET = "A non-set value is not a valid operand in this set subtracting expression.";

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

    public final static String ERR_NOTEQUAL_ITERATOR = "A non-iterator value is not a valid operand in this equality (!=) expression with another iterator.";

    public final static String ERR_LOGICALOR = "The values of the operands are not valid in this logical or expression";
    public final static String ERR_LOGICALAND = "The values of the operands are not valid in this logical and expression";

    public final static String ERR_IFELSE = "The values of the operands are not valid in this short if expression";

    public final static String ERR_IN = "The values of the operands are not valid in this type of expression (in)";

    public final static String ERR_LEN = "Len can't be used with such data type.";

    public final static String ERR_EQUAL = "The values of the operands are not valid in this equality (==) expression";
    public final static String ERR_NOTEQUAL = "The values of the operands are not valid in this equality (!=) expression";

    public final static String ERR_LOWEREQ = "The values of the operands are not valid in this relational (<=) expression";
    public final static String ERR_LOWER = "The values of the operands are not valid in this relational (<) expression";
    public final static String ERR_GREATEREQ = "The values of the operands are not valid in this relational (>=) expression";
    public final static String ERR_GREATER = "The values of the operands are not valid in this relational (>) expression";

    public final static String ERR_UNION = "The values of the operands are not valid in this union expression";
    public final static String ERR_INTERSECT = "The values of the operands are not valid in this intersecting expression";
    public final static String ERR_SET_SUBTRACT = "The values of the operands are not valid in this set subtracting expression";

    public final static String ERR_BITWISEOR = "The values of the operands are not valid in this bitwise or expression";
    public final static String ERR_BITWISEXOR = "The values of the operands are not valid in this bitwise xor expression";

    public final static String ERR_BITWISEAND = "The values of the operands are not valid in this bitwise and expression";

    public final static String ERR_SHIFTLEFT = "The values of the operands are not valid in this left shifting expression";
    public final static String ERR_SHIFTRIGHT = "The values of the operands are not valid in this right shifting expression";

    public final static String ERR_ADD = "The values of the operands are not valid in an addition expression";
    public final static String ERR_SUB = "The values of the operands are not valid in this subtracting expression";

    public final static String ERR_MUL = "The values of the operands are not valid in this multiplying expression";
    public final static String ERR_DIV = "The values of the operands are not valid in this dividing expression";
    public final static String ERR_DIV_ZERO = "It is impossible to divide by 0.";
    public final static String ERR_MOD = "The values of the operands are not valid in this dividing with a reminder expression";


    public final static String ERR_STAR = "The value of the operand are not valid in this unary (*) expression";
    public final static String ERR_POSITIVE = "The value of the operand are not valid in this unary (+) expression";
    public final static String ERR_NEGATIVE = "The value of the operand are not valid in this unary (-) expression";
    public final static String ERR_NOT = "The value of the operand is not valid in this unary (!) expression";


    public final static String ERR_LEFT_PLUSPLUS = "The value of the operand is not valid in this prefix (left ++) expression";
    public final static String ERR_RIGHT_PLUSPLUS = "The value of the operand is not valid in this postfix (right ++) expression";
    public final static String ERR_LEFT_MINUSMINUS = "The value of the operand is not valid in this prefix (left --) expression";
    public final static String ERR_MINUSMINUSMOD = "The value of the operand is not valid in this prefix (--%) expression";
    public final static String ERR_PLUSPLUSMOD = "The value of the operand is not valid in this prefix (++%) expression";


    public final static String ERR_BRACKET = "The value of the operand is not valid for accessing elements with brackets.";
    public final static String ERR_BRACKET_TOOBIG = "The operand in the bracket is too big for this expression.";
    public final static String ERR_DOT = "The value of the operand is not valid for accessing elements with dot.";
    public final static String ERR_NO_COMPONENT = "Can't access the component by dot.";

    public final static String ERR_SHIFT_TOOBIG = "The right operand is too big for this shifting expression.";
    public final static String ERR_CONDITIONAL_NO_BOOL = "The left most operand in a conditional expression must be a boolean.";


    public final static String ERR_PRINT_PARAM = "The print function must have only one parameter.";
    public final static String ERR_NO_REF = "The reference is invalid";
    public final static String ERR_IF_NOT_BOOL = "The value of the expression to evaluate in if must be boolean.";
    public final static String ERR_WHILE_NOT_BOOL = "The value of the expression to evaluate in while must be boolean.";
    public final static String ERR_DOWHILE_NOT_BOOL = "The value of the expression to evaluate in do while must be boolean.";
    public final static String ERR_REPEAT_NOT_BOOL = "The value of the expression to evaluate in repeat until must be boolean.";
    public final static String ERR_FOR_NOT_BOOL = "The value of the expression to evaluate in for must be boolean.";


    public final static String ERR_NOINT_INTERVAL = "The values of the interval's limits must be integers.";
    public final static String ERR_LIMIT = "The value of the left side must be lower than the value of the right side.";


    public final static String ERR_DATASTRUCTURE_UNDEFINED = "The data structure in the left side must be initialized first.";
    public final static String ERR_NOINT_ARRAY = "The values of array's indexes must be integers.";
    public final static String ERR_ARRAY = "The value of the operand must be an array so that its elements can be accessed.";

    public final static String ERR_PARAM_NOT_DEFINED = "The value of an input-output must be a modifiable value and it must be declared first.";
    public final static String ERR_MULTIPLE_PARAM = "A function can't have more than one parameter with the same name.";
    public final static String ERR_MODIFIES = "There is no global variable with this name.";
    public final static String ERR_RETURN = "You can only return if you are in a function.";
    public final static String ERR_FUNCTION_DEFINITION = "You can only declare functions in the global scope.";

    public final static String ERR_STRUCT = "The value of the operand must be a structure so that its elements can be accessed with point.";

    public final static String ERR_ARRAY_OUT_OF_BOUNDS = "The position in the array is out of bounds.";
    public final static String ERR_LIST_OUT_OF_BOUNDS = "The position in the list is out of bounds.";
    public final static String ERR_STRING_OUT_OF_BOUNDS = "The position in the string is out of bounds.";

    public final static String ERR_LIST_EMPTY = "The list is empty, can't getRandom iterator to first element.";

    public final static String ERR_ITERATOR_NO_NEXT = "The iterator can't be incremented.";
    public final static String ERR_ITERATOR_NO_PREVIOUS = "The Iterator can't be decremented.";
    public final static String ERR_ITERATOR_INVALID = "The Iterator is invalid.";
    public final static String ERR_ADD_ITERATOR = "The type of value is invalid for this additive expression. (only int can be added to an iterator)";
    public final static String ERR_SUBTRACT_ITERATOR = "The type of value is invalid for this subtracting expression. (only int can be subtracted from an iterator)";
    public final static String ERR_ADD_ITERATOR_TOOBIG = "No such big integers can be added to an iterator.";
    public final static String ERR_SUBTRACT_ITERATOR_TOOBIG = "No such big integers can be subtracted form an iterator.";
    public final static String ERR_ITERATOR_IS_END = "Iterator is at the end or invalid.";

    public final static String ERR_FORALL_ITERABLE_REQUIRED = "The forall structure must have an iterable value as right operand.";
    public final static String ERR_SPEC_ITERABLE_REQUIRED = "A specification must have an iterable value as source of values.";

    public final static String ERR_NOT_HOMOGENEOUS = "The set can't be made on objects of different types.";

    public final static String ERR_PARAM_NUMBER = "The number of parameters is invalid.";
    public final static String ERR_PARAM = "The parameters' types are invalid.";

    public final static String ERR_AT = "This type of value is not valid for the at function.";
    public final static String ERR_AT_TOOBIG = "The at function does not permit such large numbers as a position.";

    public final static String ERR_DELETE = "This type of value is not valid for the delete function.";

    public final static String ERR_END = "This type of value is not valid for the end function.";

    public final static String ERR_FIRST = "This type of value is not valid for the first function.";

    public final static String ERR_KEYS = "This type of value is not valid for the keys method.";

    public final static String ERR_INSERT = "This type of value is not valid for the insert function.";
    public final static String ERR_INSERT_TOOBIG = "The insert function does not permit such large numbers as a position.";

    public final static String ERR_POPBACK = "This type of value is not valid for the popBack function.";
    public final static String ERR_POPBACK_EMPTY = "The data structure is empty, there is no popBack element.";

    public final static String ERR_POPFRONT = "This type of value is not valid for the popFront function.";
    public final static String ERR_POPFRONT_EMPTY = "The data structure is empty, there is no popFront element.";

    public final static String ERR_PUSHBACK = "This type of value is not valid for the pushBack function.";

    public final static String ERR_PUSHFRONT = "This type of value is not valid for the pushFront function.";

    public final static String ERR_REMOVE = "This type of value is not valid for the remove function.";
    public final static String ERR_REMOVE_NO_SUCH_ELEMENT = "There is no such element to be removed from the set.";

    public final static String ERR_REMOVEALLEQTO = "This type of value is not valid for the removeAllEqTo function.";

    public final static String ERR_REMOVEAT = "This type of value is not valid for the removeAt function.";
    public final static String ERR_REMOVEAT_TOOBIG = "The removeAt function does not permit such large numbers as a position.";

    public final static String ERR_SIZE = "This type of value is not valid for the size function.";

    public final static String ERR_SPLIT = "This type of value is not valid for the split function.";

    public final static String ERR_TOPBACK = "This type of value is not valid for the topBack function.";
    public final static String ERR_TOPBACK_EMPTY = "The data structure is empty, there is no topBack element.";

    public final static String ERR_TOPFRONT = "This type of value is not valid for the topFront function.";
    public final static String ERR_TOPFRONT_EMPTY = "The data structure is empty, there is no topFront element.";

    public final static String ERR_UPDATE = "This type of value is not valid for the update function.";
    public final static String ERR_UPDATE_TOOBIG = "The operand for the position is too big for the parameter.";


    public final static String ERR_FUNCTION_REDEFINITION = "Another function with the same name and same number of parameters was already defined.";
    public final static String ERR_FUNCTION_UNDEFINED = "No function with this name and this number of parameters is defined";

    public final static String ERR_INVALID_CONVERSION = "The argument is invalid for the conversion.";

    public final static String ERR_METHOD = "There is no method with such name.";

    public final static String ERR_RANDOM_INT = "The paramteter of the random function needs to be an integer.";

    public final static String ERR_CHOOSE_NOT_ITERABLE = "The structure of the choose must be an iterable.";
    public final static String ERR_CHOSE_ST_BOOL = "The condition in choose must be boolean.";
    public final static String ERR_CHOSE_RESULT = "Choose can't find any suitable value.";

    public final static String ERR_UNIFORM_RESULT = "Uniform can't find any value.";


    public final static String ERR_UNIFORM_NOT_ITERABLE = "The structure of the uniform must be an iterable.";

    public final static String ERR_INVALID_PARAM = "Invalid parameter.";

    public final static String ERR_MATH_INT_OR_DOUBLE = "The parameter of a mathematical function must be numeric.";

    public final static String ERR_SPEC_BOOL = "The expression checking validity in specification must be bool.";

    public final static String ERR_ONLY_CHAR = "The value to be updated must be a single character string (a char).";

    public final static String ERR_INCLUDE = "Couldn't find: ";

    public final static String ERR_INCLUDE_CYCLE = "There is a circular including process.";

    public final static String ERR_CONTINUE = "Can't use continue outside a loop.";
    public final static String ERR_BREAK = "Can't use break outside a loop.";

    public AlkException(String text)
    {
        super(text);
    }

    public AlkException(UnwindException u)
    {
        super(u.getMessage());
    }
}
