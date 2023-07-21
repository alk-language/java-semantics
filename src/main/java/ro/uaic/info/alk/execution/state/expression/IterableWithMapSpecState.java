package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.EnvironmentProxy;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class IterableWithMapSpecState
   extends ExecutionState
{
    private List<Storable> source;
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
            getExec().deregisterEnv(env);
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
                super.handle(new AlkException(AlkException.ERR_SPEC_ITERABLE_REQUIRED));

            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            iterableValue.push(getStore().malloc().setValue(resultVal.clone(generator)), generator);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithMapSpecState copy = new IterableWithMapSpecState(primitive, tree, payload.clone(sm));
        if (source != null)
        {
            for (Storable value : source)
            {
                copy.source.add(value.weakClone(sm.getLocationMapper()));
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
