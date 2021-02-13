package execution.state.expression;

import ast.AST;
import ast.attr.BuiltInMethodASTAttr;
import execution.ExecutionResult;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.parser.env.Location;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.GeneratorState;
import util.Invoker;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class FactorPointMethod
extends GeneratorState
{
    private final List<Storable> params = new ArrayList<>();
    private final String methodName;

    private Location reference;

    public FactorPointMethod(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.methodName = tree.getAttribute(BuiltInMethodASTAttr.class).getMethod().toString();
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
        }
        else
        {
            params.add(executionResult.getValue().toRValue());
        }
    }

    @Override
    public Location getFinalResult()
    {
        try
        {
            return (Location) Invoker.invokeMethod(methodName, reference, params, generator);
        }
        catch (AlkException e) {
            super.handle(new AlkException(e.getMessage()));
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FactorPointMethod copy = new FactorPointMethod(tree, payload.clone(sm));
        copy.reference = sm.getLocationMapper().get(reference);
        for (Storable value : params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }
}
