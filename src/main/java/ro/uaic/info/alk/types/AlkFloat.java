package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.FloatAST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.math.*;

/**
 * The main and only class responsible for the float values. In Alk, the float values
 * are unbound, so we use {@link BigDecimal} as main data structure. This class is immutable,
 * so the Alk may share the same float instances across different part of code.
 * Overrides specific operations like arithmetic, bitwise, relational, etc.
 * <p>
 *     The precision of the float is always by default {@code MathContext.DECIMAL64},
 *     but can be modified at run-time.
 * </p>
 *
 * @author Alexandru Lungu
 * @since 1.0
 */
@TypeName("float")
public final class AlkFloat
extends SimpleAlkValue
{
    /** The math context used with decimal operations. This can be set-up at run-time. TODO make it private */
    public static MathContext mc = MathContext.DECIMAL64;

    /** The underlying unbound float value of this Alk float. */
    private final BigDecimal value;

    /**
     * Basic constructor that initializes an Alk float. This is private to make use of the
     * caching we already have. Therefore, to retrieve an Alk float, use {@link #get}.
     *
     * @param   value
     *          The underlying {@code BigDecimal} to be used with this Alk float.
     */
    private AlkFloat(BigDecimal value)
    {
        if (value == null)
        {
            throw new InternalException("Invalid value to instantiate Alk float: null");
        }
        this.value = value;
    }

    /**
     * A mean of retrieving a specific float. This uses the cache or instantiates
     * a new float value representation, based on a {@link BigInteger}.
     *
     * @param   value
     *          The {@link BigInteger} used as underlying value.
     *
     * @return  An Alk representation of the provided value.
     */
    public static AlkFloat get(BigInteger value)
    {
        return get(new BigDecimal(value, mc));
    }

    /**
     * A mean of retrieving a specific float. This uses the cache or instantiates
     * a new float value representation.
     *
     * @param   value
     *          The unbound float value to be wrapped.
     *
     * @return  An Alk representation of the provided float.
     */
    public static AlkFloat get(BigDecimal value)
    {
        return (AlkFloat) AlkValue.cache(new AlkFloat(value));
    }

    /**
     * Set the precision for the float computations.
     *
     * @param   precision
     *          The precision to be used with {@link BigDecimal}.
     */
    public static void setPrecision(Integer precision)
    {
        mc = new MathContext(precision, RoundingMode.HALF_UP);
    }

    /**
     * Equal implementation of the Alk float data type. This can be applied
     * only with another float or integer. If an integer is used for comparison, the integer
     * will be cast to the float data type.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if the operand has the same float value as this or if its
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
            return equal(((AlkInt) operand).toFloat());
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkBool.get(value.compareTo(((AlkFloat) operand).value) == 0);
        }

        throw new InvalidOperationException(Operator.EQUAL, this, operand);
    }

    /**
     * Lower implementation of the Alk float data type. This can be applied
     * only with another float or integer. If an integer is used for comparison, the operand
     * is translated into a float value.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if the operand has the same float value as this or if its
     *          decimal representation is lower than this.
     */
    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return lower(((AlkInt) operand).toFloat());
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkBool.get(value.compareTo(((AlkFloat) operand).value) < 0);
        }

        throw new InvalidOperationException(Operator.LOWER, this, operand);
    }

    /**
     * Multiply implementation of the Alk float data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@link BigDecimal}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The float value representing the multiplication between this and the provided operand.
     */
    @Override
    public AlkValue multiply(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return multiply(((AlkInt) operand).toFloat());
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(value.multiply(((AlkFloat) operand).value, mc));
        }

        return super.multiply(operand);
    }

    /**
     * Divide implementation of the Alk float data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@link BigDecimal}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The float value representing the division between this and the provided operand.
     */
    @Override
    public AlkValue divide(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return divide(((AlkInt) operand).toFloat());
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(value. divide(((AlkFloat) operand).value, mc));
        }

        return super.divide(operand);
    }

    /**
     * Addition implementation of the Alk float data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@link BigDecimal}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The float value representing the addition between this and the provided operand.
     */
    @Override
    public AlkValue add(AlkValue operand, LocationGenerator generator)
    {
        if (operand instanceof AlkInt)
        {
            return add(((AlkInt) operand).toFloat(), generator);
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(value.add(((AlkFloat) operand).value, mc));
        }

        return super.add(operand, generator);
    }

    /**
     * Subtract implementation of the Alk float data type. This can be applied
     * only with another integer or float. The standard Java implementation in {@link BigDecimal}
     * is used for this operation.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  The float value representing subtract between this and the provided operand.
     */
    @Override
    public AlkValue subtract(AlkValue operand)
    {
        if (operand instanceof AlkInt)
        {
            return subtract(((AlkInt) operand).toFloat());
        }
        else if (operand instanceof AlkFloat)
        {
            return AlkFloat.get(value.subtract(((AlkFloat) operand).value, mc));
        }

        return super.subtract(operand);
    }

    /**
     * Positive unary operator implementation of the Alk float data type. This operation is trivial
     * as it returns the same value as this.
     *
     * @return  The float value representing the result of unary positive operator.
     */
    @Override
    public AlkValue positive()
    {
        return this;
    }

    /**
     * Positive unary operator implementation of the Alk float data type. This operation is trivial
     * as it returns the negated value as this.
     *
     * @return  The float value representing the result of unary negative operator.
     */
    @Override
    public AlkValue negative()
    {
        return AlkFloat.get(value.negate(mc));
    }

    /**
     * Implementation of AST representation.
     *
     * @return   A float AST holding this value.
     */
    @Override
    public AST toAST()
    {
        return new FloatAST(this.toString());
    }

    /**
     * Simple equals implementation.
     *
     * @param   obj
     *          Operand to be compared with
     *
     * @return  {@code true} if the provided argument is an Alk float with the same value.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof AlkFloat))
        {
            return false;
        }

        return value.equals(((AlkFloat) obj).value);
    }

    /**
     * Simple hash code.
     *
     * @return   Hash code.
     */
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
        BigDecimal bd = value.stripTrailingZeros();
        if (bd.scale() < 1)
        {
            bd = bd.setScale(1, RoundingMode.HALF_UP);
        }
        return bd.toString();
    }

    /**
     * Convenient method to retrieve the underlying native representation. This should be used mainly
     * inside this package. Other usages should consider using the existing operators.
     *
     * @return   The underlying native value of this Alk float.
     */
    public BigDecimal unwrap()
    {
        return value;
    }

}
