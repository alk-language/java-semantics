package ro.uaic.info.alk.types;

import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.BoolAST;
import ro.uaic.info.alk.exeptions.InvalidOperationException;

/**
 * The main and only class responsible for the boolean values.
 * Overrides specific operations like logicalOr, logicalAnd and not.
 *
 * @author Alexandru Lungu
 * @since 1.0
 */
@TypeName("boolean")
public final class AlkBool
extends SimpleAlkValue
{
    /** Convenient instance of the {@code true} boolean. */
    public static final AlkBool TRUE = new AlkBool(true);

    /** Convenient instance of the {@code false} boolean. */
    public static final AlkBool FALSE = new AlkBool(false);

    /** The main storage which supports the AlkBool type. */
    private final boolean value;

    /**
     * Method to retrieve the precomputed boolean instance of
     * the provided value.
     *
     * @param   value
     *          The boolean value backing this Alk representation.
     *
     * @return  One of the two precomputed instances.
     */
    public static AlkBool get(boolean value)
    {
        return value ? TRUE : FALSE;
    }

    /**
     * Basic constructor which wraps a boolean value. This is private to
     * enforce the exclusive use of {@link #TRUE} and {@link #FALSE).
     *
     * @param   value
     *          The boolean value used to initialize the storage
     */
    private AlkBool(boolean value)
    {
        this.value = value;
    }

    /**
     * Allows to retrieve the underlying low level boolean value.
     *
     * @return   {@code true} if this Alk boolean representation stores true.
     */
    public boolean isTrue()
    {
        return value;
    }

    /**
     * Allows to retrieve the negated underlying low level boolean value.
     *
     * @return   {@code true} if this Alk boolean representation stores false.
     */
    public boolean isFalse()
    {
        return !value ;
    }

    /**
     * Basic overload of the AlkValue default logicalOr operation.
     *
     * @param   operand
     *          The right operand of the binary operation.
     *
     * @return  An AlkBool representing the result of the expression.
     */
    @Override
    public AlkBool logicalOr(AlkValue operand)
    {
        if (operand instanceof AlkBool)
        {
            return AlkBool.get(value || ((AlkBool) operand).value);
        }
        return super.logicalOr(operand);
    }

    /**
     * Basic overload of the AlkValue default logicalAnd operation
     *
     * @param   operand
     *          The right operand of the binary operation
     *
     * @return  An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool logicalAnd(AlkValue operand)
    {
        if (operand instanceof AlkBool)
        {
            return AlkBool.get(value && ((AlkBool) operand).value);
        }
        return super.logicalAnd(operand);
    }

    /**
     * Basic override of the AlkValue default not operation
     *
     * @return  An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool not()
    {
        return AlkBool.get(!value);
    }

    /**
     * Basic overload of the AlkValue default equal operation.
     *
     * @param   operand
     *          The right operand of the binary operation
     *
     * @return  An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (this == operand)
        {
            return AlkBool.TRUE;
        }

        if (operand instanceof AlkBool)
        {
            return AlkBool.FALSE;
        }

        throw new InvalidOperationException(Operator.EQUAL, this, operand);
    }

    /**
     * Basic overload of the AlkValue default lower operation.
     *
     * @param   operand
     *          The right operand of the binary operation
     *
     * @return  An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (operand instanceof AlkBool)
        {
            return AlkBool.get(!this.value && ((AlkBool) operand).value);
        }

        throw new InvalidOperationException(Operator.LOWER, this, operand);
    }

    /**
     * Basic override of the toString method.
     *
     * @return   String representation of this value.
     */
    @Override
    public String toString()
    {
        return value ? "true" : "false";
    }

    /**
     * Implementation of AST representation.
     *
     * @return   {@code true} if this is true of {@code false} otherwise
     */
    @Override
    public BoolAST toAST()
    {
        return new BoolAST(isTrue() ? "true" : "false");
    }
}
