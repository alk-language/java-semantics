package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.GeneratorState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

import static ro.uaic.info.alk.exeptions.AlkException.ERR_LIMIT;
import static ro.uaic.info.alk.exeptions.AlkException.ERR_NOINT_INTERVAL;

public class IterableWithIntervalState
   extends GeneratorState
{
    protected final List<Storable> limits = new ArrayList<>();
    protected final Primitive primitive;

    public IterableWithIntervalState(Primitive primitive, AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
        this.primitive = primitive;
    }

    @Override
    public Storable getFinalResult()
    {
        Storable x = limits.get(0);
        Storable y = limits.get(1);

        if (!(x instanceof AlkInt && y instanceof AlkInt))
        {
            super.handle(new AlkException(ERR_NOINT_INTERVAL));
            return null;
        }

        AlkInt left = (AlkInt) x;
        AlkInt right = (AlkInt) y;

        if (left.greater(right).isTrue())
        {
            super.handle(new AlkException(ERR_LIMIT));
        }

        AlkIterableValue iterableValue = getPrimitiveInstance();

        for (AlkValue i = left; i.lowereq(right).isTrue(); i = i.add(AlkInt.ONE, generator))
        {
            iterableValue.push(i, generator);
        }

        return generator.generate(iterableValue);
    }

    @Override
    public void assign(ExecutionResult result)
    {
        limits.add(result.getValue().toRValue());
    }

    protected AlkIterableValue getPrimitiveInstance()
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
    public ExecutionState clone(SplitMapper sm) {
        IterableWithIntervalState copy = new IterableWithIntervalState(primitive, tree, payload.clone(sm));
        for (Storable value : limits)
        {
            copy.limits.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }

}
