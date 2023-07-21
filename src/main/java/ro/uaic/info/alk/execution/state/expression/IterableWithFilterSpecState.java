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
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class IterableWithFilterSpecState
   extends ExecutionState
{
    private List<Storable> source;
    private int step;
    private AlkIterableValue iterableValue;
    private AlkValue validatingValue;
    private EnvironmentProxy env;
    private final Primitive primitive;
    private final String id;

    public IterableWithFilterSpecState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
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
            return super.request(tree.getChild(0));
        }

        if (step == source.size())
        {
            setResult(new ExecutionResult(iterableValue));
            getExec().deregisterEnv(env);
            return null;
        }

        validatingValue = (AlkValue) source.get(step++).toRValue();

        env = new EnvironmentProxy(getEnv());
        getExec().registerEnv(env);
        env.addTempEntry(id, validatingValue);
        return super.request(tree.getChild(1), env);
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        if (source == null)
        {
            AlkValue resultVal = (AlkValue) executionResult.getValue().toRValue();

            if (!(resultVal instanceof AlkIterableValue))
            {
                super.handle(new AlkException(AlkException.ERR_SPEC_ITERABLE_REQUIRED));
                return;
            }

            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            if (!(executionResult.getValue().toRValue() instanceof AlkBool))
                super.handle(new AlkException(AlkException.ERR_SPEC_BOOL));
            if (((AlkBool) executionResult.getValue().toRValue()).isTrue())
                iterableValue.push(validatingValue, generator);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithFilterSpecState copy = new IterableWithFilterSpecState(primitive, tree, payload.clone(sm));
        copy.step = step;

        if (source != null)
        {
            for (Storable value : source)
            {
                copy.source.add(value.weakClone(sm.getLocationMapper()));
            }
        }


        if (iterableValue != null)
        {
            copy.iterableValue = (AlkIterableValue) iterableValue.weakClone(sm.getLocationMapper());
        }

        if (this.validatingValue != null)
        {
            copy.validatingValue = this.validatingValue.weakClone(sm.getLocationMapper());
        }

        if (this.env != null)
        {
            copy.env = (EnvironmentProxy) sm.getEnvironmentMapper().get(this.env);
        }
        return super.decorate(copy, sm);
    }
}
