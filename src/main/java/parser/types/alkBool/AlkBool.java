package parser.types.alkBool;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.AlkValue;

import static parser.exceptions.AlkException.ERR_LOWER_BOOL;

public class AlkBool extends AlkValue implements Cloneable{

    public Boolean value;

    public AlkBool(boolean value) {
        type = "Bool";
        this.value = value;
    }

    public AlkBool logicalOr(AlkValue operand) throws AlkException, InterpretorException {
        LogicalBoolHelper help = new LogicalBoolHelper(value);
        return help.logicalOr(operand);
    }

    public AlkBool logicalAnd(AlkValue operand) throws AlkException, InterpretorException {
        LogicalBoolHelper help = new LogicalBoolHelper(value);
        return help.logicalAnd(operand);
    }

    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityBoolHelper help = new EqualityBoolHelper(value);
        return help.equal(operand);
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Bool"))
            throw new AlkException(ERR_LOWER_BOOL);
        return new AlkBool(!value);
    }

    public AlkBool not() throws AlkException, InterpretorException {
        UnaryBoolHelper help = new UnaryBoolHelper(value);
        return help.not();
    }

    @Override
    public AlkValue clone() {
        return new AlkBool(value);
    }

    @Override
    public String toString() {
        if (value)
            return "true";
        return "false";
    }
}
