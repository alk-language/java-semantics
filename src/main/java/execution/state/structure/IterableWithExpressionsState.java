package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

public class IterableWithExpressionsState extends GeneratorState<AlkIterableValue, Value>
{
    private ArrayList<AlkValue> array = new ArrayList<>();
    private Class<? extends AlkIterableValue> clazz;

    public IterableWithExpressionsState(ParseTree tree,
                                        Payload payload,
                                        List<? extends ParseTree> dependency,
                                        Class<? extends AlkIterableValue> clazz) {
        super(tree, payload, dependency, ExpressionVisitor.class);
        this.clazz = clazz;
    }

    @Override
    public void assign(ExecutionResult<Value> result)
    {
        array.add((AlkValue) result.getValue().toRValue());
    }

    @Override
    public AlkIterableValue getFinalResult() {
        try {
            AlkIterableValue iterableVal = clazz.newInstance();
            for (AlkValue value : array)
            {
                iterableVal.push(generator.generate(value.toRValue().clone(generator)));
            }
            return iterableVal;
        } catch (InstantiationException | IllegalAccessException e) {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                super.handle((AlkException) cause);
            throw new InternalException(e);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithExpressionsState copy = new IterableWithExpressionsState(tree, sm.getPayload(), null, clazz);

        for (AlkValue value : array)
        {
            copy.array.add(value.weakClone(sm.getLocationMapper()));
        }

        return super.decorate(copy, sm);
    }
}