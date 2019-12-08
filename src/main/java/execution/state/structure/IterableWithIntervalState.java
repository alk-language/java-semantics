package execution.state.structure;

import execution.state.SingleState;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.structure.DataStructureVisitor;
import util.Payload;
import util.exception.InternalException;
import util.types.IntervalValue;

import java.util.ArrayList;
import java.util.List;

public class IterableWithIntervalState extends SingleState<AlkIterableValue, IntervalValue>
{
    private Class<? extends AlkIterableValue> clazz;

    public IterableWithIntervalState(ParseTree tree,
                                     Payload payload,
                                     ParseTree interval,
                                     Class<? extends AlkIterableValue> clazz)
    {
        super(tree, payload, interval);
        visitor = DataStructureVisitor.class;
        this.clazz = clazz;
    }

    @Override
    protected AlkIterableValue interpretResult(IntervalValue value)
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
