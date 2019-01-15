package impl.types.alkDouble;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;

import java.math.BigDecimal;

public class AlkDouble extends AlkValue {

    public BigDecimal value;

    public AlkDouble(BigDecimal value)
    {
        type = "Double";
        this.value = value;
    }

    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityDoubleHelper help = new EqualityDoubleHelper(value);
        return help.equal(operand);
    }

    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException {
        EqualityDoubleHelper help = new EqualityDoubleHelper(value);
        return help.notequal(operand);
    }

    public AlkValue lowereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalDoubleHelper help = new RelationalDoubleHelper(value);
        return help.lowereq(operand);
    }

    public AlkValue lower(AlkValue operand) throws AlkException, InterpretorException {
        RelationalDoubleHelper help = new RelationalDoubleHelper(value);
        return help.lower(operand);
    }

    public AlkValue greatereq(AlkValue operand) throws AlkException, InterpretorException {
        RelationalDoubleHelper help = new RelationalDoubleHelper(value);
        return help.greatereq(operand);
    }

    public AlkValue greater(AlkValue operand) throws AlkException, InterpretorException {
        RelationalDoubleHelper help = new RelationalDoubleHelper(value);
        return help.greater(operand);
    }


    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException
    {
        AdditiveDoubleHelper help = new AdditiveDoubleHelper(value);
        return help.add(operand);
    }

    public AlkValue subtract(AlkValue operand) throws AlkException, InterpretorException
    {
        AdditiveDoubleHelper help = new AdditiveDoubleHelper(value);
        return help.subtract(operand);
    }

    public AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException
    {
        MultiplicativeDoubleHelper help = new MultiplicativeDoubleHelper(value);
        return help.multiply(operand);
    }

    public AlkValue divide(AlkValue operand) throws AlkException, InterpretorException
    {
        MultiplicativeDoubleHelper help = new MultiplicativeDoubleHelper(value);
        return help.divide(operand);
    }

    public AlkValue mod(AlkValue operand) throws AlkException, InterpretorException
    {
        MultiplicativeDoubleHelper help = new MultiplicativeDoubleHelper(value);
        return help.mod(operand);
    }

    public AlkValue positive() throws AlkException, InterpretorException {
        UnaryDoubleHelper help = new UnaryDoubleHelper(value);
        return help.positive();
    }

    public AlkValue negative() throws AlkException, InterpretorException {
        UnaryDoubleHelper help = new UnaryDoubleHelper(value);
        return help.negative();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
