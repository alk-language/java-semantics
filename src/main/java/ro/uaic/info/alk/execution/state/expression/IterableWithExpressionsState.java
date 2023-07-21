package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.GeneratorState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

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
            checkNotNull(value, true);
            iterableVal.push(value.toRValue(), generator);
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
