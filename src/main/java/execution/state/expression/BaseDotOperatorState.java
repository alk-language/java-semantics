package execution.state.expression;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import execution.types.alkStructure.AlkStructure;

public class BaseDotOperatorState
extends ExecutionState
{
    private final String id;
    private Location reference;

    public BaseDotOperatorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.id = tree.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public ExecutionState makeStep()
    {
        if (reference == null)
        {
            return request(tree.getChild(0));
        }

        if (reference.isUnknown())
        {
            reference.assign(new AlkStructure());
        }

        try
        {
            Location loc = ((AlkValue) reference.toRValue()).dot(id, generator);
            setResult(new ExecutionResult(loc));
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BaseDotOperatorState copy = new BaseDotOperatorState(tree, payload.clone(sm));
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}