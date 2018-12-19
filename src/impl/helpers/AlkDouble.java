package impl.helpers;

import impl.exceptions.AlkException;

import java.math.BigDecimal;

import static impl.exceptions.AlkException.*;

public class AlkDouble extends AlkValue {

    public BigDecimal value;

    public AlkDouble(BigDecimal value)
    {
        type = "Double";
        this.value = value;
    }

    @Override
    public AlkValue add(AlkValue operand) throws AlkException
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

    @Override
    public AlkValue subtract(AlkValue operand) throws AlkException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_ADD_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return subtract(((AlkInt)operand));
            case "Double": return subtract((AlkDouble)operand);
            case "String": return subtract((AlkString)operand);
            case "Bool": return subtract((AlkBool)operand);
        }
        throw new AlkException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkDouble subtract(AlkInt operand)
    {
        return new AlkDouble(value.subtract(new BigDecimal(operand.value)));
    }

    private AlkDouble subtract(AlkDouble operand)
    {
        return new AlkDouble(value.subtract(operand.value));
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
