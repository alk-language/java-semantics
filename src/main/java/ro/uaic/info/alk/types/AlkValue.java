package ro.uaic.info.alk.types;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.InvalidLeftValueException;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.ASTRepresentable;
import ro.uaic.info.alk.visitor.interpreter.RequiresGenerator;

import java.lang.ref.SoftReference;

import static ro.uaic.info.alk.util.Constants.VALUE_CACHE_SIZE;
import static ro.uaic.info.alk.exeptions.AlkException.*;

public abstract class AlkValue
implements Comparable<AlkValue>,
           ConcreteValue,
           ASTRepresentable
{
    private static SoftReference<CachableValue[]> valueCache;

    static CachableValue cache(CachableValue value)
    {
        CachableValue[] cache;
        if (valueCache == null || (cache = valueCache.get()) == null)
        {
            cache = new CachableValue[1 << VALUE_CACHE_SIZE];
            valueCache = new SoftReference<>(cache);
        }

        int hash = value.hashCode();
        int index = hash & ((1 << VALUE_CACHE_SIZE) - 1);
        CachableValue cached = cache[index];
        if (cached != null)
        {
            if (value.equals(cached))
            {
                return cached;
            }
        }

        return cache[index] = value;
    }

    @Override
    @Deprecated
    public int compareTo(AlkValue operand)
    {
        // TODO: this is not safe as the other operand can mismatch types
        // this should catch invalid operator
        if (equal(operand).isTrue()) return 0;
        if (lower(operand).isTrue()) return -1;
        return 1;
    }

    /**
     * Standard override of the toString method
     * TODO: By default, throw an exception, as the value couldn't be represented? Or find standard message?
     * @return
     * A string describing the value
     */
    @Override
    public abstract String toString();

    public abstract AlkValue weakClone(LocationMapper locationMapper);

    public abstract AlkValue clone(LocationGenerator locationGenerator);

    /**
     * Handles the logical or operation (||) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @param operand
     * The value having the role of the second operand in this binary operation
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkBool logicalOr(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.LOGICAL_OR, this, operand);
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
    public AlkBool logicalAnd(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.LOGICAL_AND, this, operand);
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
        {
            throw new InvalidOperationException(Operator.IN, this, operand);
        }

        return AlkBool.get(((AlkIterableValue) operand).has(this));
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
        return lower(operand).logicalOr(equal(operand));
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
        throw new InvalidOperationException(Operator.UNION, this, operand);
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
        throw new InvalidOperationException(Operator.INTERSECT, this, operand);
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
        throw new InvalidOperationException(Operator.SET_SUBTRACT, this, operand);
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
    public AlkValue bitwiseOr(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.BITWISE_OR, this, operand);
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
    public AlkValue bitwiseXor(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.BITWISE_XOR, this, operand);
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
    public AlkValue bitwiseAnd(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.BITWISE_AND, this, operand);
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
    public AlkValue shiftLeft(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.SHIFT_LEFT, this, operand);
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
    public AlkValue shiftRight(AlkValue operand)
    {
        throw new InvalidOperationException(Operator.SHIFT_RIGHT, this, operand);
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
    @RequiresGenerator
    public AlkValue add(AlkValue operand, LocationGenerator generator)
    {
        throw new InvalidOperationException(Operator.ADD, this, operand);
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
        throw new InvalidOperationException(Operator.SUBTRACT, this, operand);
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
        throw new InvalidOperationException(Operator.MULTIPLY, this, operand);
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
        throw new InvalidOperationException(Operator.DIVIDE, this, operand);
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
        throw new InvalidOperationException(Operator.MOD, this, operand);
    }

    /**
     * Handles the star operation (*) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
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
        throw new InvalidOperationException(Operator.POSITIVE, this);
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
        throw new InvalidOperationException(Operator.NEGATIVE, this);
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
        throw new InvalidOperationException(Operator.NOT, this);
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
        throw new InvalidOperationException(Operator.BRACKET, this, operand);
    }

    /**
     * Handles the dot operation (.) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public Location dot(String operand, LocationGenerator generator)
    {
        throw new InvalidOperationException(Operator.DOT, this);
    }


    /**
     * Handles the at built in method (at) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @RequiresGenerator
    public AlkValue at(AlkValue operand)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.AT, this, operand);
    }


    /**
     * Handles the delete built in method (delete) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
    public AlkValue delete()
    {
        throw new InternalException("Deprecated .delete()");
    }


    /**
     * Handles the end built in method (end) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
    public AlkValue end()
    {
        throw new InternalException("Deprecated .end()");
    }


    /**
     * Handles the first built in method (first) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    @Deprecated
    public AlkValue first()
    {
        throw new InternalException("Deprecated .first()");
    }


    /**
     * Handles the insert built in method (insert) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue insert(AlkValue value)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.INSERT, this, value);
    }


    /**
     * Handles the insert built in method (insert) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue insert(AlkValue position, AlkValue value, LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.INSERT, this, position, value.toRValue());
    }

    @RequiresGenerator
    public AlkValue keys()
    {
        throw new InvalidOperationException(AlkBuiltInMethod.KEYS, this);
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
        throw new InvalidOperationException(AlkBuiltInMethod.POP_BACK, this);
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
        throw new InvalidOperationException(AlkBuiltInMethod.POP_FRONT, this);
    }

    /**
     * Handles the pushBack built in method (pushBack) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     */
    public AlkValue pushBack(AlkValue value, LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.PUSH_BACK, this, value.toRValue());
    }

    /**
     * Handles the pushFront built in method (pushFront) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue pushFront(AlkValue value, LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.PUSH_FRONT, this, value.toRValue());
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
        throw new InvalidOperationException(AlkBuiltInMethod.REMOVE, this, value);
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
        throw new InvalidOperationException(AlkBuiltInMethod.REMOVE_ALL_EQ_TO, this, value);
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
        throw new InvalidOperationException(AlkBuiltInMethod.REMOVE_AT, this, position);
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
        throw new InvalidOperationException(AlkBuiltInMethod.SIZE, this);
    }


    /**
     * Handles the split built in method (split) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkArray split(LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.SPLIT, this);
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
    public AlkArray split(AlkValue pattern, LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.SPLIT, this, pattern);
    }


    /**
     * Handles the topBack built in method (topBack) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue topBack()
    {
        throw new InvalidOperationException(AlkBuiltInMethod.TOP_BACK, this);
    }


    /**
     * Handles the topFront built in method (topFront) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue topFront()
    {
        throw new InvalidOperationException(AlkBuiltInMethod.TOP_FRONT, this);
    }


    /**
     * Handles the update built in method (update) over a value.
     * By default, the operation is not supported, thus an error is thrown.
     * @return
     * The result of the expression
     * A return is valid if overridden, otherwise no-return
     */
    public AlkValue update(AlkValue position, AlkValue value, LocationGenerator generator)
    {
        throw new InvalidOperationException(AlkBuiltInMethod.UPDATE, this, position, value.toRValue());
    }

    @Override
    public AlkValue toRValue()
    {
        return this;
    }

    @Override
    public Location toLValue()
    {
        throw new InvalidLeftValueException(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof AlkValue))
        {
            return false;
        }

        try
        {
            return equal((AlkValue) obj).isTrue();
        }
        catch (InvalidOperationException ex)
        {
            return false;
        }
    }
}
