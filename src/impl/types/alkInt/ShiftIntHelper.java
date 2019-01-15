package impl.types.alkInt;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkString.AlkString;

import java.math.BigInteger;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class ShiftIntHelper {

    private BigInteger value;

    ShiftIntHelper(BigInteger value)
    {
        this.value = value;
    }

    AlkValue shiftLeft(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_SHIFTLEFT_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return shiftLeft(((AlkInt)operand));
            case "Double": return shiftLeft((AlkDouble)operand);
            case "String": return shiftLeft((AlkString)operand);
            case "Bool": return shiftLeft((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt shiftLeft(AlkInt operand) throws AlkException {
        try
        {
            return new AlkInt(value.shiftLeft(operand.value.intValueExact()));
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_SHIFT_TOOBIG);
        }
    }

    private AlkDouble shiftLeft(AlkDouble operand) throws AlkException {

        throw new AlkException(ERR_SHIFTLEFT_DOUBLE);
    }

    private AlkInt shiftLeft(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_SHIFTLEFT_BOOL);
    }

    private AlkInt shiftLeft(AlkString operand) throws AlkException {
        throw new AlkException(ERR_SHIFTLEFT_STRING);
    }



    AlkValue shiftRight(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_SHIFTRIGHT_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return shiftRight(((AlkInt) operand));
            case "Double": return shiftRight((AlkDouble) operand);
            case "String": return shiftRight((AlkString) operand);
            case "Bool": return shiftRight((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt shiftRight(AlkInt operand) throws AlkException {
        try
        {
            return new AlkInt(value.shiftRight(operand.value.intValueExact()));
        }
        catch (ArithmeticException e)
        {
            throw new AlkException(ERR_SHIFT_TOOBIG);
        }
    }

    private AlkDouble shiftRight(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_SHIFTRIGHT_DOUBLE);
    }

    private AlkInt shiftRight(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_SHIFTRIGHT_BOOL);
    }

    private AlkInt shiftRight(AlkString operand) throws AlkException {
        throw new AlkException(ERR_SHIFTRIGHT_STRING);
    }
}
