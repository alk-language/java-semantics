package impl.types;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_HAS;


public abstract class AlkValue {

    // scalar_value - Int, Double, Bool, String
    // data_structure_value - Array, List, Structure, Set
    public String type;
    public boolean isDataStructure;


    @Override
    public abstract String toString();

    //LogicalOr operators
    public AlkValue logicalOr(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOGICALOR);
    }

    //LogicalAnd operators
    public AlkValue logicalAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOGICALAND);
    }

    //In operators
    public AlkValue in(AlkValue operand) throws AlkException, InterpretorException
    {
        if (!operand.isDataStructure)
            throw new AlkException(ERR_IN);
        return new AlkBool(operand.has(this));
    }

    public boolean has(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new InterpretorException(ERR_HAS);
    }


    //Equality operators
    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_EQUAL);
    }
    public AlkValue notequal(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_NOTEQUAL);
    }


    //Relational operators
    public AlkValue lowereq(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOWEREQ);
    }
    public AlkValue lower(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_LOWER);
    }
    public AlkValue greatereq(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_GREATEREQ);
    }
    public AlkValue greater(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_GREATER);
    }

    //BitwiseOr operators
    public AlkValue bitwiseOr(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEOR);
    }
    public AlkValue bitwiseXor(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEXOR);
    }


    //BitwiseAnd operator
    public AlkValue bitwiseAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_BITWISEAND);
    }


    //Shift operators
    public AlkValue shiftLeft(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SHIFTLEFT);
    }

    public AlkValue shiftRight(AlkValue visit) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SHIFTRIGHT);
    }


    //Addition operators
    public AlkValue add(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_ADD);
    }

    public AlkValue subtract(AlkValue visit) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_SUB);
    }


    //Mulitplicative operators
    public AlkValue multiply(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_MUL);
    }
    public AlkValue divide(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_DIV);
    }
    public AlkValue mod(AlkValue operand) throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_MOD);
    }


    //Unary operators
    public AlkValue star() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_STAR);
    }
    public AlkValue positive() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_POSITIVE);
    }
    public AlkValue negative() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_NEGATIVE);
    }
    public AlkValue not() throws AlkException, InterpretorException
    {
        throw new AlkException(ERR_NOT);
    }


    //Prefix operators
    public AlkValue plusplusleft () throws AlkException {
        throw new AlkException(ERR_LEFT_PLUSPLUS);
    }

    public AlkValue bracket(int operand) throws AlkException {
        throw new AlkException(ERR_BRACKET);
    }

}
