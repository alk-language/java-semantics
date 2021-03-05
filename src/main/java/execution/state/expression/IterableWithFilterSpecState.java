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
import execution.types.alkBool.AlkBool;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import util.exception.InternalException;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_SPEC_BOOL;
import static execution.parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

public class IterableWithFilterSpecState
extends ExecutionState
{
    private List<Location> source;
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
                super.handle(new AlkException(ERR_SPEC_ITERABLE_REQUIRED));
                return;
            }

            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            if (!(executionResult.getValue().toRValue() instanceof AlkBool))
                super.handle(new AlkException(ERR_SPEC_BOOL));
            if (((AlkBool) executionResult.getValue().toRValue()).isTrue())
                iterableValue.push(generator.generate(validatingValue));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IterableWithFilterSpecState copy = new IterableWithFilterSpecState(primitive, tree, payload.clone(sm));
        copy.step = step;

        if (source != null)
        {
            for (Location value : source)
            {
                copy.source.add(sm.getLocationMapper().get(value));
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
