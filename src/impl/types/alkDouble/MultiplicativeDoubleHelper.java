package impl.types.alkDouble;

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

public class MultiplicativeDoubleHelper {

    private BigDecimal value;

    MultiplicativeDoubleHelper(BigDecimal value)
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
            case "Double": return multiply((AlkDouble)operand);
            case "String": return multiply((AlkString)operand);
            case "Bool": return multiply((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkDouble multiply(AlkInt operand)
    {
        return new AlkDouble(value.multiply(new BigDecimal(operand.value)));
    }

    private AlkDouble multiply(AlkDouble operand)
    {
        return new AlkDouble(value.multiply(operand.value));
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
            case "Double": return divide((AlkDouble)operand);
            case "String": return divide((AlkString)operand);
            case "Bool": return divide((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkDouble divide(AlkInt operand)
    {
        return divide(new AlkDouble(new BigDecimal(operand.value)));
    }

    private AlkDouble divide(AlkDouble operand)
    {
        try
        {
            return new AlkDouble(value.divide(operand.value));
        }
        catch (ArithmeticException e)
        {
            // Treated ArithmeticException
            return new AlkDouble(value.divide(operand.value, MAX_DECIMALS, RoundingMode.HALF_EVEN));
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
