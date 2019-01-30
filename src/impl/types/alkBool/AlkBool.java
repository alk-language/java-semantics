package impl.types.alkBool;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;

public class AlkBool extends AlkValue {

    public Boolean value;

    public AlkBool(boolean value) {
        type = "Bool";
        this.value = value;
    }

    public AlkValue logicalOr(AlkValue operand) throws AlkException, InterpretorException {
        LogicalBoolHelper help = new LogicalBoolHelper(value);
        return help.logicalOr(operand);
    }

    public AlkValue logicalAnd(AlkValue operand) throws AlkException, InterpretorException {
        LogicalBoolHelper help = new LogicalBoolHelper(value);
        return help.logicalAnd(operand);
    }

    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityBoolHelper help = new EqualityBoolHelper(value);
        return help.equal(operand);
    }

    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityBoolHelper help = new EqualityBoolHelper(value);
        return help.notequal(operand);
    }

    public AlkValue not() throws AlkException, InterpretorException {
        UnaryBoolHelper help = new UnaryBoolHelper(value);
        return help.not();
    }

    @Override
    public String toString() {
        if (value)
            return "true";
        return "false";
    }
}
