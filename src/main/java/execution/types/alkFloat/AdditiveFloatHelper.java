package execution.types.alkFloat;

import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.InterpretorException;
import execution.types.alkBool.AlkBool;
import execution.types.alkString.AlkString;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;

import java.math.BigDecimal;

import static execution.parser.exceptions.AlkException.*;
import static execution.parser.exceptions.AlkException.ERR_SUB_STRING;
import static execution.parser.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

class AdditiveFloatHelper {
    private BigDecimal value;

    AdditiveFloatHelper(BigDecimal value)
    {
        this.value = value;
    }

    AlkValue add(AlkValue operand)
    {
        switch(operand.type)
        {
            case "Int": return add(((AlkInt)operand));
            case "Double": return add((AlkFloat)operand);
            case "String": return add((AlkString)operand);
            case "Bool": return add((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkFloat add(AlkInt operand)
    {
        return new AlkFloat(value.add(new BigDecimal(operand.value)));
    }

    private AlkFloat add(AlkFloat operand)
    {
        return new AlkFloat(value.add(operand.value));
    }

    private AlkInt add(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_ADD_BOOL);
    }

    private AlkInt add(AlkString operand) throws AlkException {
        throw new AlkException(ERR_ADD_STRING);
    }

    AlkValue subtract(AlkValue operand)
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_SUB_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return subtract(((AlkInt)operand));
            case "Double": return subtract((AlkFloat)operand);
            case "String": return subtract((AlkString)operand);
            case "Bool": return subtract((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkFloat subtract(AlkInt operand)
    {
        return new AlkFloat(value.subtract(new BigDecimal(operand.value)));
    }

    private AlkFloat subtract(AlkFloat operand)
    {
        return new AlkFloat(value.subtract(operand.value));
    }

    private AlkFloat subtract(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_SUB_BOOL);
    }

    private AlkFloat subtract(AlkString operand) throws AlkException {
        throw new AlkException(ERR_SUB_STRING);
    }
}
