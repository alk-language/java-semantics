package impl.types;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_HAS;


public abstract class AlkValue implements Comparable<AlkValue>, Cloneable{

    // scalar_value - Int, Double, Bool, String
    // data_structure_value - Array, List, Structure, Set
    public String type;
    public boolean isDataStructure;
    public boolean isIterable;

    @Override public boolean equals(Object value)
    {
        if (!(value instanceof AlkValue)) return false;
        return compareTo((AlkValue) value)==0;
    }


    @Override public int compareTo(AlkValue operand) {
        try {
            if (((AlkBool)equal(operand)).value) return 0;
            if (((AlkBool)lower(operand)).value) return -1;
            return 1;
        } catch (AlkException e) {
            e.printException(0);
            return 0;
        } catch (InterpretorException e) {
            e.printException(0);
            return 0;
        }
    }

    public abstract AlkValue clone();


    @Override
    public abstract String toString();

    //LogicalOr operators
    public AlkBool logicalOr(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOGICALOR);
    }

    //LogicalAnd operators
    public AlkBool logicalAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOGICALAND);
    }

    //In operators
    public AlkValue in(AlkValue operand) throws AlkException, InterpretorException
    {
        if (!operand.isIterable)
            throw new AlkException(ERR_IN);
        return new AlkBool(((AlkIterableValue)operand).has(this));
    }


    //Equality operators
    public abstract AlkBool equal(AlkValue operand) throws AlkException, InterpretorException; // sunt abstracte pentru a le putea ordona

    public AlkBool notequal(AlkValue operand) throws AlkException, InterpretorException
    {
        return equal(operand).not();
    }


    //Relational operators
    public AlkBool lowereq(AlkValue operand) throws AlkException, InterpretorException
    {
        return lower(operand).logicalOr(equal(operand));
    }

    public abstract AlkBool lower(AlkValue operand) throws AlkException, InterpretorException;// sunt abstracte pentru a le putea ordona

    public AlkBool greatereq(AlkValue operand) throws AlkException, InterpretorException
    {
        return lower(operand).not();
    }
    public AlkBool greater(AlkValue operand) throws AlkException, InterpretorException
    {
        return lowereq(operand).not();
    }

    //Set operators
    public AlkValue union(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_UNION);
    }
    public AlkValue intersect(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_INTERSECT);
    }
    public AlkValue setSubtract(AlkValue operand) throws AlkException, InterpretorException {
        throw new AlkException(ERR_SET_SUBTRACT);
    }

    //BitwiseOr operators
    public AlkValue bitwiseOr(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEOR);
    }
    public AlkValue bitwiseXor(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEXOR);
    }


    //BitwiseAnd operator
    public AlkValue bitwiseAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEAND);
    }


    //Shift operators
    public AlkValue shiftLeft(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SHIFTLEFT);
    }

    public AlkValue shiftRight(AlkValue visit) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SHIFTRIGHT);
    }


    //Addition operators
    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_ADD);
    }

    public AlkValue subtract(AlkValue visit) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SUB);
    }


    //Mulitplicative operators
    public AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_MUL);
    }
    public AlkValue divide(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_DIV);
    }
    public AlkValue mod(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_MOD);
    }


    //Unary operators
    public AlkValue star() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_STAR);
    }
    public AlkValue positive() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_POSITIVE);
    }
    public AlkValue negative() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_NEGATIVE);
    }
    public AlkBool not() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_NOT);
    }


    //Prefix operators
    public AlkValue plusplusleft () throws AlkException {
        throw new AlkException(ERR_LEFT_PLUSPLUS);
    }
    public AlkValue minusminusleft() throws AlkException {
        throw new AlkException(ERR_LEFT_MINUSMINUS);
    }
    public AlkValue minusminusmod() throws AlkException {
        throw new AlkException(ERR_MINUSMINUSMOD);
    }
    public AlkValue plusplusmod() throws AlkException {
        throw new AlkException(ERR_PLUSPLUSMOD);
    }

    //Special operators
    public AlkValue bracket(int operand) throws AlkException {
        throw new AlkException(ERR_BRACKET);
    }

    public AlkValue dot(String operand) throws AlkException {
        throw new AlkException(ERR_DOT);
    }


    //BuiltInFunctions

    public AlkValue at(AlkValue operand) throws AlkException {
        throw new AlkException(ERR_AT);
    }

    public AlkValue delete() throws AlkException {
        throw new AlkException(ERR_DELETE);
    }

    public AlkValue end() throws AlkException {
        throw new AlkException(ERR_END);
    }

    public AlkValue first() throws AlkException {
        throw new AlkException(ERR_FIRST);
    }

    public AlkValue insert(AlkValue value) throws AlkException {
        throw new AlkException(ERR_INSERT);
    }

    public AlkValue insert(AlkValue position, AlkValue value) throws AlkException {
        throw new AlkException(ERR_INSERT);
    }

    public AlkValue len() throws AlkException {
        throw new AlkException(ERR_LEN);
    }

    public AlkValue popBack() throws AlkException {
        throw new AlkException(ERR_POPBACK);
    }

    public AlkValue popFront() throws AlkException {
        throw new AlkException(ERR_POPFRONT);
    }

    public AlkValue pushBack(AlkValue value) throws AlkException {
        throw new AlkException(ERR_PUSHBACK);
    }

    public AlkValue pushFront(AlkValue value) throws AlkException {
        throw new AlkException(ERR_PUSHFRONT);
    }

    public AlkValue remove(AlkValue value) throws AlkException {
        throw new AlkException(ERR_REMOVE);
    }

    public AlkValue removeAllEqTo(AlkValue value) throws AlkException {
        throw new AlkException(ERR_REMOVEALLEQTO);
    }

    public AlkValue removeAt(AlkValue position) throws AlkException {
        throw new AlkException(ERR_REMOVEAT);
    }

    public AlkValue size() throws AlkException {
        throw new AlkException(ERR_SIZE);
    }

    public AlkValue split() throws AlkException {
        throw new AlkException(ERR_SPLIT);
    }

    public AlkValue split(AlkValue pattern) throws AlkException {
        throw new AlkException(ERR_SPLIT);
    }

    public AlkValue topBack() throws AlkException {
        throw new AlkException(ERR_TOPBACK);
    }

    public AlkValue topFront() throws AlkException {
        throw new AlkException(ERR_TOPFRONT);
    }

    public AlkValue update(AlkValue position, AlkValue value) throws AlkException {
        throw new AlkException(ERR_UPDATE);
    }
}
