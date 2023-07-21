package ro.uaic.info.alk.visitor;

import ro.uaic.info.alk.enums.Operator;

public class OperatorHelper
{
    public static Operator parseBinary(String text)
    {
        switch (text)
        {
            case "||": return Operator.LOGICAL_OR;
            case "&&": return Operator.LOGICAL_AND;
            case "in": return Operator.IN;
            case "==": return Operator.EQUAL;
            case "!=": return Operator.NOT_EQUAL;
            case "<": return Operator.LOWER;
            case "<=": return Operator.LOWER_EQ;
            case ">": return Operator.GREATER;
            case ">=": return Operator.GREATER_EQ;
            case "U": return Operator.UNION;
            case "^": return Operator.INTERSECT;
            case "\\": return Operator.SET_SUBTRACT;
            case "|": return Operator.BITWISE_OR;
            case "&": return Operator.BITWISE_AND;
            case "xor": return Operator.BITWISE_XOR;
            case "<<": return Operator.SHIFT_LEFT;
            case ">>": return Operator.SHIFT_RIGHT;
            case "+": return Operator.ADD;
            case "-": return Operator.SUBTRACT;
            case "*": return Operator.MULTIPLY;
            case "/": return Operator.DIVIDE;
            case "%": return Operator.MOD;
            default: return null;
        }
    }

    public static Operator parseAssign(String text)
    {
        switch (text)
        {
            case "=": return Operator.ASSIGN;
            case "+=": return Operator.PLUS_ASSIGN;
            case "-=": return Operator.MINUS_ASSIGN;
            case "*=": return Operator.MULTIPLY_ASSIGN;
            case "/=": return Operator.DIVIDE_ASSIGN;
            case "%=": return Operator.MOD_ASSIGN;
            case "<<=": return Operator.LEFT_SHIFT_ASSIGN;
            case ">>=": return Operator.RIGHT_SHIFT_ASSIGN;
            case "|=": return Operator.BITWISE_OR_ASSIGN;
            case "&=": return Operator.BITWISE_AND_ASSIGN;
            default: return null;
        }
    }
}
