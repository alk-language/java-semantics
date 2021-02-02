package execution.state.expression;

import ast.AST;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkIterableValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import util.exception.InternalException;
import util.types.Storable;

import java.util.ArrayList;

public class IterableWithExpressionsState
extends GeneratorState
{
    private final ArrayList<Storable> array = new ArrayList<>();
    private final Primitive primitive;

    public IterableWithExpressionsState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.primitive = primitive;
    }

    @Override
    public Storable getFinalResult()
    {
        AlkIterableValue iterableVal = getPrimitiveInstance();
        for (Storable value : array)
        {
            iterableVal.push(generator.generate(value.toRValue().clone(generator)));
        }
        return generator.generate(iterableVal);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        array.add(executionResult.getValue().toRValue());
    }

    private AlkIterableValue getPrimitiveInstance()
    {
        switch (this.primitive) {
            case ARRAY:
                return new AlkArray();
            case LIST:
                return new AlkList();
            case SET:
                return new AlkSet();
            default:
                throw new InternalException("Unrecognized primitive type for this compound representation!");
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        IterableWithExpressionsState copy = new IterableWithExpressionsState(primitive, tree, payload.clone(sm));

        for (Storable value : array)
        {
            copy.array.add(value.weakClone(sm.getLocationMapper()));
        }

        return super.decorate(copy, sm);
    }
}
