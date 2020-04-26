package execution.types.alkInt;

import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;

import java.math.BigInteger;

// TODO: define AlkInt constants for efficiency
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

    public AlkBool equal(AlkValue operand) throws AlkException {
        EqualityIntHelper help = new EqualityIntHelper(value);
        return help.equal(operand);
    }

    public AlkBool lower(AlkValue operand) throws AlkException {
        RelationalIntHelper help = new RelationalIntHelper(value);
        return help.lower(operand);
    }

    public AlkValue bitwiseOr(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseOr(operand);
    }

    public AlkValue bitwiseXor(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseXor(operand);
    }

    public AlkValue bitwiseAnd(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseAnd(operand);
    }

    public AlkValue shiftLeft(AlkValue operand) throws AlkException {
        ShiftIntHelper help = new ShiftIntHelper(value);
        return help.shiftLeft(operand);
    }

    public AlkValue shiftRight(AlkValue operand) throws AlkException {
        ShiftIntHelper help = new ShiftIntHelper(value);
        return help.shiftRight(operand);
    }

    public AlkValue divide(AlkValue operand) throws AlkException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.divide(operand);
    }

    public AlkValue mod(AlkValue operand) throws AlkException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.mod(operand);
    }

    public AlkValue add(AlkValue operand) throws AlkException {
        AdditiveIntHelper help = new AdditiveIntHelper(value);
        return help.add(operand);
    }

    public AlkValue subtract(AlkValue operand) throws AlkException {
        AdditiveIntHelper help = new AdditiveIntHelper(value);
        return help.subtract(operand);
    }

    public AlkValue multiply(AlkValue operand) throws AlkException {
        MultiplicativeIntHelper help = new MultiplicativeIntHelper(value);
        return help.multiply(operand);
    }

    public AlkValue positive() throws AlkException {
        UnaryIntHelper help = new UnaryIntHelper(value);
        return help.positive();
    }

    public AlkValue negative() throws AlkException {
        UnaryIntHelper help = new UnaryIntHelper(value);
        return help.negative();
    }

    public AlkValue plusplusleft() {
        value = value.add(new BigInteger(String.valueOf(1)));
        return this;
    }

    public AlkValue minusminusleft() throws AlkException {
        value = value.subtract(new BigInteger(String.valueOf(1)));
        return this;
    }

    public AlkValue plusplusright() {
        AlkInt ans = new AlkInt(value);
        value = value.add(new BigInteger(String.valueOf(1)));
        return ans;
    }

    public AlkValue minusminusright() throws AlkException {
        AlkInt ans = new AlkInt(value);
        value = value.subtract(new BigInteger(String.valueOf(1)));
        return ans;
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        return new AlkInt(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
