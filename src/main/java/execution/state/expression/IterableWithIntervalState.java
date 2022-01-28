package execution.state.expression;

import ast.AST;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkInt.AlkInt;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import util.exception.InternalException;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_LIMIT;
import static execution.parser.exceptions.AlkException.ERR_NOINT_INTERVAL;

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

        if (left.greater(right).getValue())
        {
            super.handle(new AlkException(ERR_LIMIT));
        }

        AlkIterableValue iterableValue = getPrimitiveInstance();

        for (AlkValue i = left.clone(null); i.lowereq(right).isTrue(); i.plusplusright())
        {
            iterableValue.push(generator.generate(i));
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
