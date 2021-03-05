package execution.state.expression;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.EnvironmentProxy;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import util.exception.InternalException;
import util.types.Storable;

import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

public class IterableWithMapSpecState
extends ExecutionState
{
    private List<Location> source;
    private AlkIterableValue iterableValue;
    private int step;
    private EnvironmentProxy env;
    private final Primitive primitive;
    private final String id;

    public IterableWithMapSpecState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.primitive = primitive;
        this.id = tree.getAttribute(IdASTAttr.class).getId();
        this.iterableValue = getIterable();
    }

    private AlkIterableValue getIterable()
    {
        switch (primitive) {
            case ARRAY:
                return new AlkArray();
            case LIST:
                return new AlkList();
            case SET:
                return new AlkSet();
            default:
                throw new InternalException("Unrecognized primitive type for filter spec.");
        }
    }

    @Override
    public ExecutionState makeStep()
    {
        if (source == null)
        {
            return super.request(tree.getChild(1));
        }

        if (step == source.size())
        {
            setResult(new ExecutionResult(iterableValue));
            return null;
        }

        env = new EnvironmentProxy(getEnv());
        getExec().registerEnv(env);
        env.addTempEntry(id, source.get(step++).toRValue());
        return super.request(tree.getChild(0), env);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        Storable resultVal = executionResult.getValue().toRValue();
        if (source == null)
        {
            if (!(resultVal instanceof AlkIterableValue))
                super.handle(new AlkException(ERR_SPEC_ITERABLE_REQUIRED));

            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            if (!(resultVal instanceof AlkValue))
                super.handle(new AlkException("An iterable should be filled only with AlkValues."));

            iterableValue.push(getStore().malloc().assign(((AlkValue) resultVal).clone(generator)));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithMapSpecState copy = new IterableWithMapSpecState(primitive, tree, payload.clone(sm));
        if (source != null)
        {
            for (Location value : source)
            {
                copy.source.add(sm.getLocationMapper().get(value));
            }
        }

        copy.iterableValue = (AlkIterableValue) iterableValue.weakClone(sm.getLocationMapper());
        copy.step = step;

        if (this.env != null)
        {
            copy.env = (EnvironmentProxy) sm.getEnvironmentMapper().get(env);
        }
        return super.decorate(copy, sm);
    }
}
