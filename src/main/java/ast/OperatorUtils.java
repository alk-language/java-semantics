package ast;

import util.exception.InternalException;
import ast.enums.Operator;

public class OperatorUtils
{
    public static String toString(Operator op)
    {
        switch (op)
        {
            case LOGICALOR: return "||";
            case LOGICALAND: return "&&";
            case IN: return "in";
            case EQUAL: return "==";
            case NOTEQUAL: return "!=";
            case LOWER: return "<";
            case LOWEREQ: return "<=";
            case GREATER: return ">";
            case GREATEREQ: return ">=";
            case UNION: return "U";
            case INTERSECT: return "^";
            case SETSUBTRACT: return "\\";
            case BITWISEOR: return "|";
            case BITWISEAND: return "&";
            case BITWISEXOR: return "xor";
            case SHIFTLEFT: return "<<";
            case SHIFTRIGHT: return ">>";
            case ADD: case POSITIVE: return "+";
            case SUBTRACT: case NEGATIVE: return "-";
            case MULTIPLY: return "*";
            case DIVIDE: return "/";
            case MOD: return "%";
            case PLUSPLUSLEFT: case PLUSPLUSRIGHT: return "++";
            case MINUSMINUSLEFT: case MINUSMINUSRIGHT: return "++";
            case NOT: return "!";
            default:
                throw new InternalException("Can't represent the operator with trivial string!");
        }
    }
}
