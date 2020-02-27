package execution.types.alkFloat;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import execution.types.alkString.AlkString;
import execution.types.AlkValue;

import java.math.BigDecimal;

import static parser.exceptions.AlkException.*;
import static parser.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class EqualityFloatHelper {

    private BigDecimal value;

    EqualityFloatHelper(BigDecimal value)
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

    private AlkBool equal(AlkInt operand)
    {
        return new AlkBool(value.compareTo(new BigDecimal(operand.value)) == 0);
    }

    private AlkBool equal(AlkFloat operand)
    {
        return new AlkBool(value.compareTo(operand.value)==0);
    }

    private AlkBool equal(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_BOOL);
    }

    private AlkBool equal(AlkString operand) throws AlkException {
        throw new AlkException(ERR_EQUAL_STRING);
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

    private AlkBool notequal(AlkInt operand)
    {
        return new AlkBool(value.compareTo(new BigDecimal(operand.value)) != 0);
    }

    private AlkBool notequal(AlkFloat operand)
    {
        return new AlkBool(value.compareTo(operand.value)!=0);
    }

    private AlkBool notequal(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_NOTEQUAL_BOOL);
    }

    private AlkBool notequal(AlkString operand) throws AlkException {
        throw new AlkException(ERR_NOTEQUAL_STRING);
    }
}
