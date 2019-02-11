package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;
import impl.types.alkFloat.AlkFloat;
import impl.types.alkInt.AlkInt;
import impl.types.AlkValue;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class EqualityStringHelper {

    private String value;

    EqualityStringHelper(String value)
    {
        this.value = value;
    }

    AlkValue equal(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_EQUAL_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return equal(((AlkInt)operand));
            case "Double": return equal((AlkFloat)operand);
            case "String": return equal((AlkString)operand);
            case "Bool": return equal((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool equal(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_INT);
    }

    private AlkBool equal(AlkFloat operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_DOUBLE);
    }

    private AlkBool equal(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_BOOL);
    }

    private AlkBool equal(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value)==0);
    }

    AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_NOTEQUAL_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return notequal(((AlkInt)operand));
            case "Double": return notequal((AlkFloat)operand);
            case "String": return notequal((AlkString)operand);
            case "Bool": return notequal((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool notequal(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_NOTEQUAL_INT);
    }

    private AlkBool notequal(AlkFloat operand) throws AlkException {
        throw new AlkException(ERR_NOTEQUAL_DOUBLE);
    }

    private AlkBool notequal(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_BOOL);
    }

    private AlkBool notequal(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value)!=0);
    }
}
