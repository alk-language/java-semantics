package execution.types.alkInt;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkString.AlkString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static parser.constants.Constants.MAX_DECIMALS;
import static parser.exceptions.AlkException.*;
import static parser.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class MultiplicativeIntHelper {

    private BigInteger value;

    MultiplicativeIntHelper(BigInteger value)
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

    private AlkInt multiply(AlkInt operand)
    {
        return new AlkInt(value.multiply(operand.value));
    }

    private AlkFloat multiply(AlkFloat operand)
    {
        return new AlkFloat(new BigDecimal(value).multiply(operand.value));
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

    private AlkInt divide(AlkInt operand)
    {
        return new AlkInt(value.divide(operand.value));
    }

    private AlkFloat divide(AlkFloat operand)
    {
        try
        {
            return new AlkFloat(new BigDecimal(value).divide(operand.value));
        }
        catch (ArithmeticException e)
        {
            // Treated ArithmeticException
            return new AlkFloat(new BigDecimal(value).divide(operand.value, MAX_DECIMALS, RoundingMode.HALF_EVEN));
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
        if (operand.isDataStructure)
            throw new AlkException(ERR_MOD_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return mod(((AlkInt)operand));
            case "Double": return mod((AlkFloat)operand);
            case "String": return mod((AlkString)operand);
            case "Bool": return mod((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt mod(AlkInt operand) throws AlkException {
        try {
            return new AlkInt(value.remainder(operand.value));
        }
        catch (ArithmeticException e)
        {
            // Treated ArithmeticException
            throw new AlkException(ERR_DIV_ZERO);
        }
    }

    private AlkFloat mod(AlkFloat operand) throws AlkException {
        throw new AlkException(ERR_MOD_DOUBLE);
    }

    private AlkInt mod(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_MOD_BOOL);
    }

    private AlkInt mod(AlkString operand) throws AlkException {
        throw new AlkException(ERR_MOD_STRING);
    }
}
