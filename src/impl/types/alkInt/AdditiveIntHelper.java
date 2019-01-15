package impl.types.alkInt;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkString.AlkString;
import impl.types.AlkValue;

import java.math.BigDecimal;
import java.math.BigInteger;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;


/**
 *   This is a class that defines the additive operations (+, -) with an integer left operand
 */

class AdditiveIntHelper {

    private BigInteger value;

    AdditiveIntHelper(BigInteger value)
    {
        this.value = value;
    }

    AlkValue add(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_ADD_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return add(((AlkInt)operand));
            case "Double": return add((AlkDouble)operand);
            case "String": return add((AlkString)operand);
            case "Bool": return add((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt add(AlkInt operand)
    {
        return new AlkInt(value.add(operand.value));
    }

    private AlkDouble add(AlkDouble operand)
    {
        return new AlkDouble(new BigDecimal(value).add(operand.value));
    }

    private AlkInt add(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_ADD_BOOL);
    }

    private AlkInt add(AlkString operand) throws AlkException {
        throw new AlkException(ERR_ADD_STRING);
    }



    AlkValue subtract(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_SUB_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return subtract(((AlkInt) operand));
            case "Double": return subtract((AlkDouble) operand);
            case "String": return subtract((AlkString) operand);
            case "Bool": return subtract((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt subtract(AlkInt operand)
    {
        return new AlkInt(value.subtract(operand.value));
    }

    private AlkDouble subtract(AlkDouble operand)
    {
        return new AlkDouble(new BigDecimal(value).subtract(operand.value));
    }

    private AlkInt subtract(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_SUB_BOOL);
    }

    private AlkInt subtract(AlkString operand) throws AlkException {
        throw new AlkException(ERR_SUB_STRING);
    }
}
