package parser.types.alkString;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.alkBool.AlkBool;
import parser.types.alkFloat.AlkFloat;
import parser.types.alkInt.AlkInt;
import parser.types.AlkValue;

import static parser.exceptions.AlkException.*;
import static parser.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class EqualityStringHelper {

    private String value;

    EqualityStringHelper(String value)
    {
        this.value = value;
    }

    AlkBool equal(AlkValue operand) throws AlkException, InterpretorException
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
