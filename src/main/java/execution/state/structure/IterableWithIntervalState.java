package execution.state.structure;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.SingleState;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.structure.DataStructureVisitor;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.IntervalValue;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

public class IterableWithIntervalState extends SingleState
{
    private final Class<? extends AlkIterableValue> clazz;

    public IterableWithIntervalState(AST tree,
                                     ExecutionPayload executionPayload,
                                     AST interval,
                                     Class<? extends AlkIterableValue> clazz)
    {
        super(tree, executionPayload, interval);
        this.clazz = clazz;
    }

    @Override
    protected AlkIterableValue interpretResult(Value value)
    {
        if (!(value.toRValue() instanceof IntervalValue))
            throw new InternalException("Non-interval value passed to interval state.");

        IntervalValue interval = (IntervalValue) value.toRValue();
        try {
            AlkIterableValue iterableValue = clazz.newInstance();
            List<AlkValue> array = new ArrayList<>();

            for (AlkInt val : interval)
                array.add(val);

            for (AlkValue val : array)
            {
                iterableValue.push(generator.generate(val.toRValue().clone(generator)));
            }
            return iterableValue;
        } catch (InstantiationException | IllegalAccessException e) {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                super.handle((AlkException) cause);
            throw new InternalException(e);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithIntervalState copy = new IterableWithIntervalState(tree, payload.clone(sm), null, clazz);
        return super.decorate(copy, sm);
    }
}
