package impl.types.alkString;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkInt.AlkInt;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class RelationalStringHelper {
    private String value;

    RelationalStringHelper(String value) {
        this.value = value;
    }

    AlkValue lowereq(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_LOWEREQ_DATA_STRUCTURE);
        switch (operand.type) {
            case "Int":
                return lowereq(((AlkInt) operand));
            case "Double":
                return lowereq((AlkDouble) operand);
            case "String":
                return lowereq((AlkString) operand);
            case "Bool":
                return lowereq((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool lowereq(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_LOWEREQ_INT);
    }

    private AlkBool lowereq(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_LOWEREQ_DOUBLE);
    }

    private AlkBool lowereq(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_LOWEREQ_BOOL);
    }

    private AlkBool lowereq(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value) <= 0);
    }


    AlkValue lower(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_LOWEREQ_DATA_STRUCTURE);
        switch (operand.type) {
            case "Int":
                return lower(((AlkInt) operand));
            case "Double":
                return lower((AlkDouble) operand);
            case "String":
                return lower((AlkString) operand);
            case "Bool":
                return lower((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool lower(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_LOWER_INT);
    }

    private AlkBool lower(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_LOWER_DOUBLE);
    }

    private AlkBool lower(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_LOWER_BOOL);
    }

    private AlkBool lower(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value) < 0);
    }


    AlkValue greatereq(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_GREATEREQ_DATA_STRUCTURE);
        switch (operand.type) {
            case "Int":
                return greatereq(((AlkInt) operand));
            case "Double":
                return greatereq((AlkDouble) operand);
            case "String":
                return greatereq((AlkString) operand);
            case "Bool":
                return greatereq((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool greatereq(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_GREATEREQ_INT);
    }

    private AlkBool greatereq(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_GREATEREQ_DOUBLE);
    }

    private AlkBool greatereq(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_GREATEREQ_BOOL);
    }

    private AlkBool greatereq(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value) >= 0);
    }


    AlkValue greater(AlkValue operand) throws AlkException, InterpretorException {
        if (operand.isDataStructure)
            throw new AlkException(ERR_GREATER_DATA_STRUCTURE);
        switch (operand.type) {
            case "Int":
                return greater(((AlkInt) operand));
            case "Double":
                return greater((AlkDouble) operand);
            case "String":
                return greater((AlkString) operand);
            case "Bool":
                return greater((AlkBool) operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkBool greater(AlkInt operand) throws AlkException {
        throw new AlkException(ERR_GREATER_INT);
    }

    private AlkBool greater(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_GREATER_DOUBLE);
    }

    private AlkBool greater(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_GREATER_BOOL);
    }

    private AlkBool greater(AlkString operand) throws AlkException {
        return new AlkBool(value.compareTo(operand.value) > 0);
    }

}
