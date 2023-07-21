package ro.uaic.info.alk.ast;

import ro.uaic.info.alk.ast.expr.*;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.enums.Operator;

import java.util.List;

public class OperatorUtils
{
    public static String toString(Operator op)
    {
        return op.getSyntax();
    }

    public static AST getOperatorAST(Operator op, List<AST> children)
    {
        switch (op) {
            case LOGICAL_OR: return LogicalOrAST.createBinary(op, children);
            case LOGICAL_AND: return LogicalAndAST.createBinary(op, children);
            case IN: return InExprAST.createBinary(op, children);
            case EQUAL: case NOT_EQUAL: return EqualityAST.createBinary(op, children);
            case LOWER: case LOWER_EQ: case GREATER: case GREATER_EQ: return RelationalAST.createBinary(op, children);
            case UNION: case INTERSECT: case SET_SUBTRACT: return SetExprAST.createBinary(op, children);
            case BITWISE_OR: case BITWISE_XOR: return BitwiseOrAST.createBinary(op, children);
            case BITWISE_AND: return BitwiseAndAST.createBinary(op, children);
            case SHIFT_LEFT: case SHIFT_RIGHT: return ShiftAST.createBinary(op, children);
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
