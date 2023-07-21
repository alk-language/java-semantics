package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.IntAST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.*;
import ro.uaic.info.alk.exeptions.ErrorHandler;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The main and only class responsible for the integer values. In Alk, the integer values
 * are unbound, so we use {@link BigInteger} as main data structure. This class is immutable,
 * so the Alk may share the same integer instances across different part of code.
 * Overrides specific operations like arithmetic, bitwise, relational, etc.
 *
 * @author Alexandru Lungu
 * @since 1.0
 */
@TypeName("integer")
public class AlkInt
extends SimpleAlkValue
{
    /** Convenient instance representing the zero integer value. */
    public static final AlkInt ZERO = new AlkInt(BigInteger.ZERO);

    /** Convenient instance representing the one integer value. */
    public static final AlkInt ONE = new AlkInt(BigInteger.ONE);

    /** Convenient instance representing the two integer value. */
    public static final AlkInt TWO = new AlkInt(BigInteger.valueOf(2));

    /** The size of the static int cache. The size of the cache will be 2 ^ {@code INT_STATIC_CACHE_SIZE}. */
    private static final int INT_STATIC_CACHE_SIZE = 6;

    /** A static cache of some of the first positive integer numbers. */
    private static SoftReference<AlkInt[]> staticCache;

    /** The underlying unbound integer value. */
    private final BigInteger value;

    /**
     * Basic constructor that wraps a standard unbound integer value.
     *
     * @param   value
     *          The unbound integer value to be wrapped by this representation.
     */
    private AlkInt(BigInteger value)
    {
        if (value == null)
        {
            throw new InternalException("Invalid value to instantiate Alk integer: null");
        }
        this.value = value;
    }

    /**
     * A mean of retrieving a specific integer. This uses the cache or instantiates
     * a new integer value representation.
     *
     * @param   value
     *          The unbound integer value to be wrapped.
     *
     * @return  An Alk representation of the provided integer.
     */
    public static AlkInt get(AlkFloat value)
    {
        return get(value.unwrap().toBigInteger());
    }

    /**
     * A mean of retrieving a specific integer. This uses the cache or instantiates
     * a new integer value representation.
     *
     * @param   value
     *          The unbound integer value to be wrapped.
     *
     * @return  An Alk representation of the provided integer.
     */
    public static AlkInt get(int value)
    {
        return get(BigInteger.valueOf(value));
    }

    /**
     * A mean of retrieving a specific integer. This uses the cache or instantiates
     * a new integer value representation.
     *
     * @param   value
     *          The unbound integer value to be wrapped.
     *
     * @return  An Alk representation of the provided integer.
     */
    public static AlkInt get(BigInteger value)
    {
        try
        {
            int intValue = value.intValueExact();
            if (0 <= intValue && intValue < (1 << INT_STATIC_CACHE_SIZE))
            {
                AlkInt[] cache;

                if (staticCache == null || (cache = staticCache.get()) == null)
                {
                    cache = new AlkInt[Math.max(3, 1 << INT_STATIC_CACHE_SIZE)];
                    cache[0] = ZERO;
                    cache[1] = ONE;
                    cache[2] = TWO;
                    staticCache = new SoftReference<>(cache);
                }

                if (cache[intValue] == null)
                {
                    cache[intValue] = new AlkInt(BigInteger.valueOf(intValue));
                }

                return cache[intValue];
            }

            return (AlkInt) AlkValue.cache(new AlkInt(value));
        }
        catch (ArithmeticException e)
        {
            // don't cache this Alk int as it is too big anyway; the change of cache hit is low
            return new AlkInt(value);
        }
    }

    /**
     * Equal implementation of the Alk integer data type. This can be applied
     * only with another integer or float. If a float is used for comparison, the float
     * should have only 0 digits after the floating point in regard to the specified scale.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if the operand has the same integer value as this or if its
     *          decimal representation matches accordingly.
     */
    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (this == operand)
        {
            return AlkBool.TRUE;
        }

        if (operand instanceof AlkInt)
        {
            return AlkBool.get(value.equals(((AlkInt) operand).value));
        }
        else if (operand instanceof AlkFloat)
        {
            BigDecimal other = ((AlkFloat) operand).unwrap();
            return AlkBool.get(new BigDecimal(value, AlkFloat.mc).compareTo(other) == 0);
        }

        throw new InvalidOperationException(Operator.EQUAL, this, operand);
    }

    /**
     * Lower implementation of the Alk integer data type. This can be applied
     * only with another integer or float. If a float is used for comparison, this value
     * is translated into a float value and the comparison is done accoriding to the
     * float - float comparison.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if the operand has the same integer value as this or if its
     *          decimal representation is lower than the provided operand.
     */
    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return AlkBool.get(value.compareTo(((AlkInt) operand).value) < 0);
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkBool.get(new BigDecimal(value, AlkFloat.mc).compareTo(((AlkFloat) operand).unwrap()) < 0);
        }

        throw new InvalidOperationException(Operator.LOWER, this, operand);
    }

    /**
     * Bitwise OR implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the bitwise OR between this and the provided
     *          operand.
     */
    @Override
    public AlkValue bitwiseOr(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            if (this.lower(AlkInt.ZERO).isTrue() || operand.lower(AlkInt.ZERO).isTrue())
            {
                throw new InvalidOperationException(Operator.BITWISE_OR, this, operand);
            }

            return AlkInt.get(value.or(((AlkInt) operand).value));
        }

        return super.bitwiseOr(operand);
    }

    /**
     * Bitwise XOR implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the bitwise XOR between this and the provided
     *          operand.
     */
    @Override
    public AlkValue bitwiseXor(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            if (this.lower(AlkInt.ZERO).isTrue() || operand.lower(AlkInt.ZERO).isTrue())
            {
                throw new InvalidOperationException(Operator.BITWISE_XOR, this, operand);
            }

            return AlkInt.get(value.xor(((AlkInt) operand).value));
        }

        return super.bitwiseXor(operand);
    }

    /**
     * Bitwise AND implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the bitwise AND between this and the provided
     *          operand.
     */
    @Override
    public AlkValue bitwiseAnd(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            if (this.lower(AlkInt.ZERO).isTrue() || operand.lower(AlkInt.ZERO).isTrue())
            {
                throw new InvalidOperationException(Operator.BITWISE_AND, this, operand);
            }

            return AlkInt.get(value.and(((AlkInt) operand).value));
        }

        return super.bitwiseAnd(operand);
    }

    /**
     * Shift left implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     * <p>
     *    The operand shouldn't exceed the size of the native Java integer, otherwise the
     *    shifting is considered too big, so an exception is thrown.
     * </p>
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the shift left between this and the provided
     *          operand.
     */
    @Override
    public AlkValue shiftLeft(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            if (this.lower(AlkInt.ZERO).isTrue() || operand.lower(AlkInt.ZERO).isTrue())
            {
                throw new InvalidOperationException(Operator.SHIFT_LEFT, this, operand);
            }

            try
            {
                return AlkInt.get(value.shiftLeft(((AlkInt) operand).value.intValueExact()));
            }
            catch (ArithmeticException e)
            {
                throw new AlkException("Shifting too big! The right operand is too big for this operation.");
            }
        }

        return super.shiftLeft(operand);
    }

    /**
     * Shift right implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     * <p>
     *    The operand shouldn't exceed the size of the native Java integer, otherwise the
     *    shifting is considered too big, so an exception is thrown.
     * </p>
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the shift right between this and the provided
     *          operand.
     */
    @Override
    public AlkValue shiftRight(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            if (this.lower(AlkInt.ZERO).isTrue() || operand.lower(AlkInt.ZERO).isTrue())
            {
                throw new InvalidOperationException(Operator.SHIFT_RIGHT, this, operand);
            }

            try
            {
                return AlkInt.get(value.shiftRight(((AlkInt) operand).value.intValueExact()));
            }
            catch (ArithmeticException e)
            {
                return AlkInt.ZERO;
            }
        }

        return super.shiftRight(operand);
    }

    /**
     * Divide implementation of the Alk integer data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     * <p>
     *    The operand shouldn't be zero, otherwise an exception is thrown.
     * </p>
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the division between this and the provided operand.
     */
    @Override
    public AlkValue divide(AlkValue operand)
    {
        try
        {
            if (operand instanceof AlkInt)
            {
                return AlkInt.get(value.divide(((AlkInt) operand).value));
            }
            else if (operand instanceof AlkFloat)
            {
                BigDecimal other = ((AlkFloat) operand).unwrap();
                return AlkFloat.get(new BigDecimal(value, AlkFloat.mc).divide(other, AlkFloat.mc));
            }
        }
        catch (ArithmeticException e)
        {
            throw new DivisionByZeroException(Operator.DIVIDE, this);
        }

        return super.divide(operand);
    }

    /**
     * Modulo implementation of the Alk integer data type. This can be applied
     * only with another integer. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     * <p>
     *    The operand shouldn't be zero, otherwise an exception is thrown.
     * </p>
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the modulo between this and the provided operand.
     */
    @Override
    public AlkValue mod(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            try
            {
                return AlkInt.get(value.remainder(((AlkInt) operand).value));
            }
            catch (ArithmeticException e)
            {
                throw new DivisionByZeroException(Operator.MOD, this);
            }
        }

        return super.mod(operand);
    }

    /**
     * Multiply implementation of the Alk integer data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the multiplication between this and the provided operand.
     */
    @Override
    public AlkValue multiply(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return AlkInt.get(value.multiply(((AlkInt) operand).value));
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(new BigDecimal(value, AlkFloat.mc).multiply(((AlkFloat) operand).unwrap(), AlkFloat.mc));
        }

        return super.multiply(operand);
    }

    /**
     * Addition implementation of the Alk integer data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the addition between this and the provided operand.
     */
    public AlkValue add(AlkValue operand)
    {
        return add(operand, null);
    }

    /**
     * Addition implementation of the Alk integer data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the addition between this and the provided operand.
     */
    @Override
    public AlkValue add(AlkValue operand, LocationGenerator generator)
    {
        if (operand instanceof AlkInt)
        {
            return AlkInt.get(value.add(((AlkInt) operand).value));
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(new BigDecimal(value, AlkFloat.mc).add(((AlkFloat) operand).unwrap(), AlkFloat.mc));
        }

        return super.add(operand, generator);
    }

    /**
     * Subtraction implementation of the Alk integer data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@code BigInteger}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The integer value representing the subtraction between this and the provided operand.
     */
    @Override
    public AlkValue subtract(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return AlkInt.get(value.subtract(((AlkInt) operand).value));
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(new BigDecimal(value, AlkFloat.mc).subtract(((AlkFloat) operand).unwrap(), AlkFloat.mc));
        }

        return super.subtract(operand);
    }

    /**
     * Positive unary operator implementation of the Alk integer data type. This operation is trivial
     * as it returns the same value as this.
     *
     * @return  The integer value representing the result of unary positive operator.
     */
    @Override
    public AlkValue positive()
    {
        return this;
    }

    /**
     * Positive unary operator implementation of the Alk integer data type. This operation is trivial
     * as it returns the negated value as this.
     *
     * @return  The integer value representing the result of unary negative operator.
     */
    @Override
    public AlkValue negative()
    {
        return AlkInt.get(value.negate());
    }

    /**
     * Implementation of AST representation.
     *
     * @return   An int AST holding this value.
     */
    @Override
    public AST toAST()
    {
        return new IntAST(this.toString());
    }

    /**
     * Helper method that allows us to identify is this integer is in range [left, right) -
     * inclusive in left and excelusive in right.
     *
     * @param   left
     *          The left inclusive side of the interval.
     * @param   right
     *          The right exclusive side of the interval.
     *
     * @return  {@code true} if this vlaue is inside the provided range.
     */
    @Deprecated
    public boolean inRange(int left, int right)
    {
        // TODO: move this into a value helper; this doesn't look right being here
        return 0 <= value.compareTo(BigInteger.valueOf(left)) &&
               value.compareTo(BigInteger.valueOf(right)) < 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof AlkInt))
        {
            return false;
        }

        return value.equals(((AlkInt) obj).value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    /**
     * Basic override of the toString method.
     *
     * @return   String representation of this value.
     */
    @Override
    public String toString()
    {
        return value.toString();
    }

    /**
     * Package private method allowing other types to easily unwrap the Alk integer. Don't expose this
     * as working directly on the underlying value isn't encouraged. The other methods of the Alk integer
     * should be enough to demotivate the need of retrieving the underlying value.
     *
     * @return   Retrieve the underlying {@link BigInteger} instance.
     */
    public AlkFloat toFloat()
    {
        return AlkFloat.get(value);
    }

    /**
     * Simple mean of accessing the underlying native int value. This should be removed as
     * it is unsafe. It presumes that the value can be stored in the native int value.
     *
     * @return   The interval integer representation.
     */
    public int intValue(ErrorHandler<Integer> eh)
    {
        try
        {
            return value.intValueExact();
        }
        catch (ArithmeticException e)
        {
            return eh.handle(e);
        }
    }

    /**
     * Retrieve the number of bits used by the integer representation. This is already
     * cached by the underlying {@code BigInteger}.
     *
     * @return   The number of bits used by the integer value. For example, 4 (100b) has
     *           3 bits and 10 (1010b) has 4 bits.
     */
    public int bitLength()
    {
        // TODO: what happens with negative integers?
        return value.bitLength();
    }
}
