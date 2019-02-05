package impl.types.alkInt;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AlkInt extends AlkValue {

    public BigInteger value;

    public AlkInt(BigInteger value)
    {
        type = "Int";
        this.value = value;
    }

    public AlkInt(int value)
    {
        type = "Int";
        this.value = BigInteger.valueOf(value);
    }

    public AlkValue plusplusleft() {
        value = value.add(new BigInteger(String.valueOf(1)));
        return this;
    }

    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityIntHelper help = new EqualityIntHelper(value);
        return help.equal(operand);
    }
    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityIntHelper help = new EqualityIntHelper(value);
        return help.notequal(operand);
    }

    public AlkBool lowereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalIntHelper help = new RelationalIntHelper(value);
        return help.lowereq(operand);
    }

    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalIntHelper help = new RelationalIntHelper(value);
        return help.lower(operand);
    }

    public AlkBool greatereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalIntHelper help = new RelationalIntHelper(value);
        return help.greatereq(operand);
    }

    public AlkBool greater(AlkValue operand) throws AlkException, InterpretorException {
        RelationalIntHelper help = new RelationalIntHelper(value);
        return help.greater(operand);
    }

    public AlkValue bitwiseOr(AlkValue operand) throws AlkException, InterpretorException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseOr(operand);
    }

    public AlkValue bitwiseXor(AlkValue operand) throws AlkException, InterpretorException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseXor(operand);
    }

    public AlkValue bitwiseAnd(AlkValue operand) throws AlkException, InterpretorException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseAnd(operand);
    }

    public AlkValue shiftLeft(AlkValue operand) throws AlkException, InterpretorException {
        ShiftIntHelper help = new ShiftIntHelper(value);
        return help.shiftLeft(operand);
    }

    public AlkValue shiftRight(AlkValue operand) throws AlkException, InterpretorException {
        ShiftIntHelper help = new ShiftIntHelper(value);
        return help.shiftRight(operand);
    }

    public AlkValue divide(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.divide(operand);
    }

    public AlkValue mod(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.mod(operand);
    }

    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException {
        AdditiveIntHelper help = new AdditiveIntHelper(value);
        return help.add(operand);
    }

    public AlkValue subtract(AlkValue operand) throws AlkException, InterpretorException {
        AdditiveIntHelper help = new AdditiveIntHelper(value);
        return help.subtract(operand);
    }

    public AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.multiply(operand);
    }

    public AlkValue positive() throws AlkException, InterpretorException {
        UnaryIntHelper help = new UnaryIntHelper(value);
        return help.positive();
    }

    public AlkValue negative() throws AlkException, InterpretorException {
        UnaryIntHelper help = new UnaryIntHelper(value);
        return help.negative();
    }

    @Override
    public AlkValue clone() {
        return new AlkInt(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
