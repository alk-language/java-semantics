package execution.state.structure;

import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.ArrayVisitor;
import util.exception.InternalException;
import util.types.PairValue;
import util.types.Value;

public class ArrayWithIntervalState extends SingleState<AlkArray, PairValue>
{

    public ArrayWithIntervalState(alkParser.ArrayWithIntervalContext tree, ArrayVisitor visitor)
    {
        super(tree, visitor, tree.interval());
    }

    @Override
    protected AlkArray interpretResult(PairValue value)
    {
        AlkArray array = new AlkArray();
        for (AlkInt val : value)
            array.push(val);
        return array;
    }
}
