package impl.types.alkFloat;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.alkString.AlkString;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static impl.constants.Constants.MAX_DECIMALS;
import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class MultiplicativeFloatHelper {

    private BigDecimal value;

    MultiplicativeFloatHelper(BigDecimal value)
    {
        this.value = value;
    }

    AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_MUL_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return multiply(((AlkInt)operand));
            case "Double": return multiply((AlkFloat)operand);
            case "String": return multiply((AlkString)operand);
            case "Bool": return multiply((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkFloat multiply(AlkInt operand)
    {
        return new AlkFloat(value.multiply(new BigDecimal(operand.value)));
    }

    private AlkFloat multiply(AlkFloat operand)
    {
        return new AlkFloat(value.multiply(operand.value));
    }

    private AlkInt multiply(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_MUL_BOOL);
    }

    private AlkInt multiply(AlkString operand) throws AlkException {
        throw new AlkException(ERR_MUL_STRING);
    }




    AlkValue divide(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_DIV_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return divide(((AlkInt)operand));
            case "Double": return divide((AlkFloat)operand);
            case "String": return divide((AlkString)operand);
            case "Bool": return divide((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkFloat divide(AlkInt operand)
    {
        return divide(new AlkFloat(new BigDecimal(operand.value)));
    }

    private AlkFloat divide(AlkFloat operand)
    {
        try
        {
            return new AlkFloat(value.divide(operand.value));
        }
        catch (ArithmeticException e)
        {
            // Treated ArithmeticException
            return new AlkFloat(value.divide(operand.value, MAX_DECIMALS, RoundingMode.HALF_EVEN));
        }
    }

    private AlkInt divide(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_DIV_BOOL);
    }

    private AlkInt divide(AlkString operand) throws AlkException {
        throw new AlkException(ERR_DIV_STRING);
    }



    AlkValue mod(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_MOD_DOUBLE);
    }
}
