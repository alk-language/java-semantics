package execution.types.alkInt;

import ast.AST;
import ast.expr.IntAST;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;

import java.math.BigInteger;

// TODO: define AlkInt constants for efficiency
public class AlkInt
extends AlkValue
{

    public static final AlkInt ONE = new AlkInt(BigInteger.ONE);
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

    public AlkValue bitwiseor(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseOr(operand);
    }

    public AlkValue bitwisexor(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseXor(operand);
    }

    public AlkValue bitwiseand(AlkValue operand) throws AlkException {
        BitwiseIntHelper help = new BitwiseIntHelper(value);
        return help.bitwiseAnd(operand);
    }

    public AlkValue shiftleft(AlkValue operand) throws AlkException {
        ShiftIntHelper help = new ShiftIntHelper(value);
        return help.shiftLeft(operand);
    }

    public AlkValue shiftright(AlkValue operand) throws AlkException {
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

    public AlkValue add(AlkValue operand, LocationGenerator generator) throws AlkException {
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
    public AlkValue clone(LocationGenerator locationGenerator) {
        return new AlkInt(value);
    }

    @Override
    public AlkValue weakClone(LocationMapper locationMapper) {
        return new AlkInt(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public AST toAST()
    {
        return new IntAST(this.toString());
    }
}
