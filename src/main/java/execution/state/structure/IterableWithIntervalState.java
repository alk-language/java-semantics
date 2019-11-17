package execution.state.structure;

import execution.state.SingleState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.ArrayVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.exception.InternalException;
import util.types.PairValue;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

public class IterableWithIntervalState extends SingleState<AlkValue, PairValue>
{
    private Class<? extends AlkIterableValue> clazz;

    public IterableWithIntervalState(ParseTree tree,
                                     DataStructureVisitor visitor,
                                     ParseTree interval,
                                     Class<? extends AlkIterableValue> clazz)
    {
        super(tree, visitor, interval);
        this.clazz = clazz;
    }

    @Override
    protected AlkValue interpretResult(PairValue value)
    {
        try {
            AlkIterableValue iterableValue = clazz.newInstance();
            List<AlkValue> array = new ArrayList<>();

            for (AlkInt val : value)
                array.add(val);

            iterableValue.addAll(array);
            return iterableValue;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new InternalException(e);
        }
    }
}
