package visitor;

public class OperatorHelper
{
    public static Operator parseBinary(String text)
    {
        switch (text)
        {
            case "||": return Operator.LOGICALOR;
            case "&&": return Operator.LOGICALAND;
            case "in": return Operator.IN;
            case "==": return Operator.EQUAL;
            case "!=": return Operator.NOTEQUAL;
            case "<": return Operator.LOWER;
            case "<=": return Operator.LOWEREQ;
            case ">": return Operator.GREATER;
            case ">=": return Operator.GREATEREQ;
            case "U": return Operator.UNION;
            case "^": return Operator.INTERSECT;
            case "\\": return Operator.SETSUBTRACT;
            case "|": return Operator.BITWISEOR;
            case "&": return Operator.BITWISEAND;
            case "xor": return Operator.BITWISEXOR;
            case "<<": return Operator.SHIFTLEFT;
            case ">>": return Operator.SHIFTRIGHT;
            case "+": return Operator.ADD;
            case "-": return Operator.SUBTRACT;
            case "*": return Operator.MULTIPLY;
            case "/": return Operator.DIVIDE;
            case "%": return Operator.MOD;
            default: return null;
        }
    }
}
