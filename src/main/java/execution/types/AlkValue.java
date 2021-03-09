package execution.types;

import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import symbolic.CPValue;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.ASTRepresentable;
import visitor.interpreter.RequiresGenerator;

import static execution.parser.exceptions.AlkException.*;

/**
 *  The main abstract class describing a value in Alk.
 *  TODO: Take care with default method behavior if not overridden. Some of the methods there may not be implemented.
 */
public abstract class AlkValue
implements Comparable<AlkValue>,
           BaseValue,
           ASTRepresentable
{
    /** Describes the type of the current value, can have one of the following:
     * TODO: replace the type with instance of checker
     * scalar_value - Int, Double, Bool, String
     * data_structure_value - Array, List, Structure, Set
     */
    @Deprecated
    public String type;

    /**
     * Flag to indicate if the current value is a data structure
     * TODO: replace with instance of data strcuture, create abstract class
     */
    @Deprecated
    public boolean isDataStructure;

    /**
     * Standard override of the equals method
     * TODO: Why is the value of type Object?
     * @param value
     * The Object used as comparable
     * @return
     * A flag dictating if the current value is equal or not with {@value}
     */
    @Override
    public boolean equals(Object value)
    {
        if (!(value instanceof AlkValue))
        {
            return false;
        }
        return compareTo((AlkValue) value) == 0;
    }

    @Override
    public boolean equals(CPValue value)
    {
        return equals((Object) value);
    }

    /**
     * Standard override of the compareTo method
     * TODO: change so that compareTo can rise an exception, due to unimplemented equal/lower.
     * @param operand
     * The operand used as comparable
     * @return
     * -1, 0 or 1 depending on the result of the comparison
     */
    @Override
    public int compareTo(AlkValue operand)
    {
        if (equal(operand).getValue()) return 0;
        if (lower(operand).getValue()) return -1;
        return 1;
    }

    /**
     * Standard override of the toString method
     * TODO: By default, throw an exception, as the value couldn't ve represented? Or find standard message?
     * @return
     * A string describing the value
     */
    @Override
    public abstract String toString();

    /**
     * All children should implement the clone method, as they are immutable
     * @return
     * A value representing a copy of the value
     */
    public abstract AlkValue weakClone(LocationMapper locationMapper);

    public abstract AlkValue clone(LocationGenerator locationGenerator);

    public AlkValue ifelse(AlkValue expr1, AlkValue expr2) { throw new AlkException(ERR_IFELSE); }

    /**
     * Handles the logical or operation (||) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool logicalor(AlkValue operand)
    {
        throw new AlkException(ERR_LOGICALOR);
    }


    /**
     * Handles the logical and operation (&&) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool logicaland(AlkValue operand)
    {
        throw new AlkException(ERR_LOGICALAND);
    }


    /**
     * Handles the in operation (in) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * TODO: Move the implementation in the children.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue in(AlkValue operand)
    {
        if (!(operand instanceof AlkIterableValue))
            throw new AlkException(ERR_IN);

        return new AlkBool(((AlkIterableValue)operand).has(this));
    }


    /**
     * Handles the equal operation (==) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * TODO: Can the abstract restraint be removed and replaced with interfaces?
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
    public abstract AlkBool equal(AlkValue operand);


    /**
     * Handles the not equal operation (!=) over a value.
     * By default, the operation makes use of the equal method.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool notequal(AlkValue operand)
    {
        return equal(operand).not();
    }


    /**
     * Handles the lower operation (<) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * TODO: Can the abstract restraint be removed and replaced with interfaces?
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
    public abstract AlkBool lower(AlkValue operand);


    /**
     * Handles the lower or equal operation (<=) over a value.
     * By default, the operation makes use of the lower, equal and logicalOr methods.
     * TODO: Do not take logicalOr for granted.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool lowereq(AlkValue operand)
    {
        return lower(operand).logicalor(equal(operand));
    }


    /**
     * Handles the greater or equal operation (>=) over a value.
     * By default, the operation makes use of the lower and not methods.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool greatereq(AlkValue operand)
    {
        return lower(operand).not();
    }


    /**
     * Handles the greater operation (>) over a value.
     * By default, the operation makes use of the lowerEq and not methods.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool greater(AlkValue operand)
    {
        return lowereq(operand).not();
    }


    /**
     * Handles the set union operation (U) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @RequiresGenerator
    public AlkValue union(AlkValue operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_UNION);
    }


    /**
     * Handles the set intersect operation (^) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @RequiresGenerator
    public AlkValue intersect(AlkValue operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_INTERSECT);
    }


    /**
     * Handles the set substract operation (\) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @RequiresGenerator
    public AlkValue setsubtract(AlkValue operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_SET_SUBTRACT);
    }


    /**
     * Handles the bitwise or operation (|) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue bitwiseor(AlkValue operand)
    {
        throw new AlkException(ERR_BITWISEOR);
    }


    /**
     * Handles the bitwise xor operation (xor) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue bitwisexor(AlkValue operand)
    {
        throw new AlkException(ERR_BITWISEXOR);
    }


    /**
     * Handles the bitwise and operation (&) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue bitwiseand(AlkValue operand)
    {
        throw new AlkException(ERR_BITWISEAND);
    }


    /**
     * Handles the shift left operation (<<) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue shiftleft(AlkValue operand)
    {
        throw new AlkException(ERR_SHIFTLEFT);
    }


    /**
     * Handles the shift right operation (>>) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue shiftright(AlkValue operand)
    {
        throw new AlkException(ERR_SHIFTRIGHT);
    }


    /**
     * Handles the additive operation (+) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue add(AlkValue operand)
    {
        throw new AlkException(ERR_ADD);
    }


    /**
     * Handles the subtraction operation (-) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue subtract(AlkValue operand)
    {
        throw new AlkException(ERR_SUB);
    }


    /**
     * Handles the multiply operation (*) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue multiply(AlkValue operand)
    {
        throw new AlkException(ERR_MUL);
    }


    /**
     * Handles the divide operation (/) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue divide(AlkValue operand)
    {
        throw new AlkException(ERR_DIV);
    }


    /**
     * Handles the mod operation (%) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue mod(AlkValue operand)
    {
        throw new AlkException(ERR_MOD);
    }


    /**
     * Handles the star operation (*) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue star()
    {
        throw new AlkException(ERR_STAR);
    }


    /**
     * Handles the positive operation (+) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue positive()
    {
        throw new AlkException(ERR_POSITIVE);
    }


    /**
     * Handles the negative operation (-) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue negative()
    {
        throw new AlkException(ERR_NEGATIVE);
    }


    /**
     * Handles the multiply operation (!) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool not()
    {
        throw new AlkException(ERR_NOT);
    }


    public AlkValue minusminusright()
    {
        //TODO: implement properly
        return minusminusleft();
    }

    /**
     * Handles the plus plus left operation (++) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue plusplusleft()
    {
        throw new AlkException(ERR_LEFT_PLUSPLUS);
    }

    /**
     * Handles the plus plus left operation (++) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue plusplusright()
    {
        throw new AlkException(ERR_RIGHT_PLUSPLUS);
    }



    /**
     * Handles the minus minus left operation (--) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue minusminusleft()
    {
        throw new AlkException(ERR_LEFT_MINUSMINUS);
    }


    /**
     * Handles the minus minus mod operation (--%) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue minusminusmod()
    {
        throw new AlkException(ERR_MINUSMINUSMOD);
    }


    /**
     * Handles the plus plus mod operation (++%) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue plusplusmod()
    {
        throw new AlkException(ERR_PLUSPLUSMOD);
    }


    /**
     * Handles the bracket operation ([]) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @RequiresGenerator
    public Location bracket(AlkValue operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_BRACKET);
    }


    /**
     * Handles the dot operation (--%) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location dot(String operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_DOT);
    }


    /**
     * Handles the at built in method (at) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location at(AlkValue operand, LocationGenerator generator)
    {
        throw new AlkException(ERR_AT);
    }


    /**
     * Handles the delete built in method (delete) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue delete()
    {
        throw new AlkException(ERR_DELETE);
    }


    /**
     * Handles the end built in method (end) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue end()
    {
        throw new AlkException(ERR_END);
    }


    /**
     * Handles the first built in method (first) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue first()
    {
        throw new AlkException(ERR_FIRST);
    }


    /**
     * Handles the insert built in method (insert) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue insert(Location value)
    {
        throw new AlkException(ERR_INSERT);
    }


    /**
     * Handles the insert built in method (insert) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue insert(AlkValue position, Location value)
    {
        throw new AlkException(ERR_INSERT);
    }


    /**
     * Handles the len built in method (len) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue len()
    {
        return size();
    }


    /**
     * Handles the popBack built in method (popBack) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue popBack()
    {
        throw new AlkException(ERR_POPBACK);
    }


    /**
     * Handles the popFront built in method (popFront) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue popFront()
    {
        throw new AlkException(ERR_POPFRONT);
    }


    /**
     * Handles the pushBack built in method (pushBack) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     */
    public AlkValue pushBack(Location value)
    {
        throw new AlkException(ERR_PUSHBACK);
    }


    /**
     * Handles the pushFront built in method (pushFront) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue pushFront(Location value)
    {
        throw new AlkException(ERR_PUSHFRONT);
    }


    /**
     * Handles the remove built in method (remove) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue remove(AlkValue value)
    {
        throw new AlkException(ERR_REMOVE);
    }


    /**
     * Handles the removeAllEqTo built in method (removeAllEqTo) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue removeAllEqTo(AlkValue value)
    {
        throw new AlkException(ERR_REMOVEALLEQTO);
    }

    /**
     * Handles the removeAt built in method (removeAt) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue removeAt(AlkValue position)
    {
        throw new AlkException(ERR_REMOVEAT);
    }


    /**
     * Handles the size built in method (size) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue size()
    {
        throw new AlkException(ERR_SIZE);
    }


    /**
     * Handles the split built in method (split) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location split(LocationGenerator generator)
    {
        throw new AlkException(ERR_SPLIT);
    }


    /**
     * Handles the split built in method (split) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param pattern
     * The pattern in regex form after which the value is split
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location split(AlkValue pattern, LocationGenerator generator)
    {
        throw new AlkException(ERR_SPLIT);
    }


    /**
     * Handles the topBack built in method (topBack) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location topBack()
    {
        throw new AlkException(ERR_TOPBACK);
    }


    /**
     * Handles the topFront built in method (topFront) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location topFront()
    {
        throw new AlkException(ERR_TOPFRONT);
    }


    /**
     * Handles the update built in method (update) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue update(AlkValue position, Location value)
    {
        throw new AlkException(ERR_UPDATE);
    }

    @Override
    public AlkValue toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new InternalException("Can't obtain a reference out of this value.");
    }
}
