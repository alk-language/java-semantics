package parser.types.alkBool;

import parser.exceptions.AlkException;
import parser.types.AlkComparable;
import parser.types.AlkValue;

import static parser.exceptions.AlkException.ERR_EQUAL_BOOL;
import static parser.exceptions.AlkException.ERR_LOWER_BOOL;

/**
 * The main and only class responsible for the boolean values.
 * Overrides specific operations like logicalOr, logicalAnd and not.
 */
public class AlkBool extends AlkValue implements AlkComparable<AlkBool>
{

    /** the main storage which backs the AlkBool type*/
    private Boolean value;

    /**
     * Basic constructor which wraps a boolean value
     * @param value
     * The boolean value used to initialize the storage
     */
    public AlkBool(boolean value)
    {
        type = "Bool";
        this.value = value;
    }


    /**
     * Basic getter for the value
     * @return
     * The value of the boolean
     */
    public boolean getValue()
    {
        return value;
    }


    /**
     * Basic overload of the AlkValue default logicalOr operation
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    public AlkBool logicalOr(AlkBool operand)
    {
        return new AlkBool(value || operand.value);
    }


    /**
     * Basic overload of the AlkValue default logicalAnd operation
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    public AlkBool logicalAnd(AlkBool operand)
    {
        return new AlkBool(value && operand.value);
    }


    /**
     * Basic override of the AlkValue default not operation
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool not()
    {
        return new AlkBool(!value);
    }


    /**
     * Basic overload of the AlkValue default equal operation
     * TODO: remove when it won't be abstract in the parent
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    @Deprecated
    public AlkBool equal(AlkValue operand)
    {
        if (!(operand instanceof AlkBool))
            throw new AlkException(ERR_EQUAL_BOOL);
        return new AlkBool(value == ((AlkBool)operand).value);
    }


    /**
     * Basic overload of the AlkValue default lower operation
     * TODO: remove when it won't be abstract in the parent
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    @Deprecated
    public AlkBool lower(AlkValue operand)
    {
        if (!(operand instanceof AlkBool))
            throw new AlkException(ERR_LOWER_BOOL);
        return new AlkBool(!value);
    }


    /**
     * Basic override of the AlkComparable equal method
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool equal(AlkBool operand)
    {
        return new AlkBool(value == operand.value);
    }


    /**
     * Basic override of the AlkComparable lower method
     * @param operand
     * The right operand of the binary operation
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    public AlkBool lower(AlkBool operand)
    {
        return new AlkBool(!value);
    }


    /**
     * Basic override of the clone method, imposed by the abstract parent
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    public AlkValue clone()
    {
        return new AlkBool(value);
    }


    /**
     * Basic override of the toString method, imposed by the abstract parent
     * @return
     * An AlkBool representing the result of the expression
     */
    @Override
    public String toString()
    {
        if (value)
            return "true";
        return "false";
    }

    public boolean isTrue() {
        return value;
    }
}
