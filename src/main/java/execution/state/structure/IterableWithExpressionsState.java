package execution.state.structure;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;

import java.util.ArrayList;

public class IterableWithExpressionsState extends GeneratorState
{
    private final ArrayList<AlkValue> array = new ArrayList<>();
    private final Class<? extends AlkIterableValue> clazz;

    public IterableWithExpressionsState(AST tree,
                                        ExecutionPayload executionPayload,
                                        Class<? extends AlkIterableValue> clazz) {
        super(tree, executionPayload);
        this.clazz = clazz;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        array.add((AlkValue) executionResult.getValue().toRValue());
    }

    @Override
    public Location getFinalResult() {
        try {
            AlkIterableValue iterableVal = clazz.newInstance();
            for (AlkValue value : array)
            {
                iterableVal.push(generator.generate(value.toRValue().clone(generator)));
            }

            return generator.generate(iterableVal);
        } catch (InstantiationException | IllegalAccessException e) {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                super.handle((AlkException) cause);
            throw new InternalException(e);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithExpressionsState copy = new IterableWithExpressionsState(tree, payload.clone(sm), clazz);

        for (AlkValue value : array)
        {
            copy.array.add(value.weakClone(sm.getLocationMapper()));
        }

        return super.decorate(copy, sm);
    }
}