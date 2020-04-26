package execution.types.alkFloat;

import execution.types.alkInt.AlkInt;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AlkFloat extends AlkValue
{

    public BigDecimal value;

    public AlkFloat(BigDecimal value) {
        type = "Double";
        this.value = value;
    }

    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityFloatHelper help = new EqualityFloatHelper(value);
        return help.equal(operand);
    }

    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalFloatHelper help = new RelationalFloatHelper(value);
        return help.lower(operand);
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

    public AlkValue plusplusleft() {
        value = value.add(new BigDecimal(String.valueOf(1)));
        return this;
    }

    public AlkValue minusminusleft() throws AlkException {
        value = value.subtract(new BigDecimal(String.valueOf(1)));
        return this;
    }

    public AlkValue plusplusright() {
        AlkFloat ans = new AlkFloat(value);
        value = value.subtract(new BigDecimal(String.valueOf(1)));
        return ans;
    }

    public AlkValue minusminusright() throws AlkException {
        AlkFloat ans = new AlkFloat(value);
        value = value.subtract(new BigDecimal(String.valueOf(1)));
        return ans;
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        return new AlkFloat(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
