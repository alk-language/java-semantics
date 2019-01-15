package impl.types.alkBool;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkInt.AlkInt;
import impl.types.alkString.AlkString;
import impl.types.AlkValue;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class LogicalBoolHelper {
    private Boolean value;

    LogicalBoolHelper(Boolean value)
    {
        this.value = value;
    }

    AlkValue logicalAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_LOGICALAND_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return logicalAnd(((AlkInt)operand));
            case "Double": return logicalAnd((AlkDouble)operand);
            case "String": return logicalAnd((AlkString)operand);
            case "Bool": return logicalAnd((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool logicalAnd(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_LOGICALAND_INT);
    }

    private AlkBool logicalAnd(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_LOGICALAND_DOUBLE);
    }

    private AlkBool logicalAnd(AlkBool operand) throws AlkException {
        return new AlkBool(value && operand.value);
    }

    private AlkBool logicalAnd(AlkString operand) throws AlkException {
        throw new AlkException(ERR_LOGICALAND_STRING);
    }



    AlkValue logicalOr(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_LOGICALOR_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return logicalOr(((AlkInt)operand));
            case "Double": return logicalOr((AlkDouble)operand);
            case "String": return logicalOr((AlkString)operand);
            case "Bool": return logicalOr((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool logicalOr(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_LOGICALOR_INT);
    }

    private AlkBool logicalOr(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_LOGICALOR_DOUBLE);
    }

    private AlkBool logicalOr(AlkBool operand) throws AlkException {
        return new AlkBool(value || operand.value);
    }

    private AlkBool logicalOr(AlkString operand) throws AlkException {
        throw new AlkException(ERR_LOGICALOR_STRING);
    }
}
