package impl.helpers;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;


public abstract class AlkValue {

    // scalar_value - Int, Double, Bool, String
    // data_structure_value - Array, List, Structure, Set
    public String type;
    public boolean isDataStructure;


    @Override
    public abstract String toString();


    public abstract AlkValue add(AlkValue operand) throws AlkException, InterpretorException;
    public abstract AlkValue subtract(AlkValue visit) throws AlkException, InterpretorException;
}
