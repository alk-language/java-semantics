package impl.helpers;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;

import java.math.BigDecimal;
import java.math.BigInteger;

import static impl.exceptions.AlkException.*;

public class AlkInt extends AlkValue {

    public BigInteger value;

    public AlkInt(BigInteger value)
    {
        type = "Int";
        this.value = value;
    }

    @Override
    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException
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
        throw new AlkException(ERR_VALUE_TYPE_UNRECOGNIZED);
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



    @Override
    public AlkValue subtract(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_ADD_DATA_STRUCTURE);
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

    @Override
    public String toString() {
        return value.toString();
    }
}
