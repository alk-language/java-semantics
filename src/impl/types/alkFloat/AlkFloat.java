package impl.types.alkFloat;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;

import java.math.BigDecimal;

public class AlkFloat extends AlkValue {

    public BigDecimal value;

    public AlkFloat(BigDecimal value) {
        type = "Double";
        this.value = value;
    }

    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityFloatHelper help = new EqualityFloatHelper(value);
        return help.equal(operand);
    }

    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityFloatHelper help = new EqualityFloatHelper(value);
        return help.notequal(operand);
    }

    public AlkBool lowereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalFloatHelper help = new RelationalFloatHelper(value);
        return help.lowereq(operand);
    }

    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalFloatHelper help = new RelationalFloatHelper(value);
        return help.lower(operand);
    }

    public AlkBool greatereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalFloatHelper help = new RelationalFloatHelper(value);
        return help.greatereq(operand);
    }

    public AlkBool greater(AlkValue operand) throws AlkException, InterpretorException {
        RelationalFloatHelper help = new RelationalFloatHelper(value);
        return help.greater(operand);
    }


    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException {
        AdditiveFloatHelper help = new AdditiveFloatHelper(value);
        return help.add(operand);
    }

    public AlkValue subtract(AlkValue operand) throws AlkException, InterpretorException {
        AdditiveFloatHelper help = new AdditiveFloatHelper(value);
        return help.subtract(operand);
    }

    public AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeFloatHelper help = new MultiplicativeFloatHelper(value);
        return help.multiply(operand);
    }

    public AlkValue divide(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeFloatHelper help = new MultiplicativeFloatHelper(value);
        return help.divide(operand);
    }

    public AlkValue mod(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeFloatHelper help = new MultiplicativeFloatHelper(value);
        return help.mod(operand);
    }

    public AlkValue positive() throws AlkException, InterpretorException {
        UnaryFloatHelper help = new UnaryFloatHelper(value);
        return help.positive();
    }

    public AlkValue negative() throws AlkException, InterpretorException {
        UnaryFloatHelper help = new UnaryFloatHelper(value);
        return help.negative();
    }

    @Override
    public AlkValue clone() {
        return new AlkFloat(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
