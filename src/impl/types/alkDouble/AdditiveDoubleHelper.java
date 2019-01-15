package impl.types.alkDouble;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;
import impl.types.alkString.AlkString;
import impl.types.AlkValue;
import impl.types.alkInt.AlkInt;

import java.math.BigDecimal;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.AlkException.ERR_SUB_STRING;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

class AdditiveDoubleHelper {
    private BigDecimal value;

    AdditiveDoubleHelper(BigDecimal value)
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

    private AlkDouble add(AlkInt operand)
    {
        return new AlkDouble(value.add(new BigDecimal(operand.value)));
    }

    private AlkDouble add(AlkDouble operand)
    {
        return new AlkDouble(value.add(operand.value));
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
            case "Int": return subtract(((AlkInt)operand));
            case "Double": return subtract((AlkDouble)operand);
            case "String": return subtract((AlkString)operand);
            case "Bool": return subtract((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkDouble subtract(AlkInt operand)
    {
        return new AlkDouble(value.subtract(new BigDecimal(operand.value)));
    }

    private AlkDouble subtract(AlkDouble operand)
    {
        return new AlkDouble(value.subtract(operand.value));
    }

    private AlkDouble subtract(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_SUB_BOOL);
    }

    private AlkDouble subtract(AlkString operand) throws AlkException {
        throw new AlkException(ERR_SUB_STRING);
    }
}
