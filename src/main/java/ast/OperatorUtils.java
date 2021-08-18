package ast;

import ast.expr.*;
import util.exception.InternalException;
import ast.enums.Operator;

import java.util.List;

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

    public static AST getOperatorAST(Operator op, List<AST> children)
    {
        switch (op) {
            case LOGICALOR: return LogicalOrAST.createBinary(op, children);
            case LOGICALAND: return LogicalAndAST.createBinary(op, children);
            case IN: return InExprAST.createBinary(op, children);
            case EQUAL: case NOTEQUAL: return EqualityAST.createBinary(op, children);
            case LOWER: case LOWEREQ: case GREATER: case GREATEREQ: return RelationalAST.createBinary(op, children);
            case UNION: case INTERSECT: case SETSUBTRACT: return SetExprAST.createBinary(op, children);
            case BITWISEOR: case BITWISEXOR: return BitwiseOrAST.createBinary(op, children);
            case BITWISEAND: return BitwiseAndAST.createBinary(op, children);
            case SHIFTLEFT: case SHIFTRIGHT: return ShiftAST.createBinary(op, children);
            case ADD: case SUBTRACT: return AdditiveAST.createBinary(op, children);
            case MULTIPLY: case DIVIDE: case MOD: return MultiplicativeAST.createBinary(op, children);
            case PLUSPLUSLEFT: case MINUSMINUSLEFT: return PrefixAST.createUnary(op, children);
            case POSITIVE: case NEGATIVE: case NOT: return UnaryAST.createUnary(op, children);
            case PLUSPLUSRIGHT: case MINUSMINUSRIGHT: return PostfixAST.createUnary(op, children);
            case BRACKET: return BracketAST.createBinary(op, children);
            default:
                throw new InternalException("Unrecognized operator when symbolically interpreting an expression: " + op);
        }
    }
}
