package execution.state.expression;

import ast.AST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.state.ExecutionState;
import execution.types.AlkMap;

public class BaseMapWithCompsState
extends ExecutionState
{
    private AlkMap mapping = new AlkMap();
    private int step = 0;
    private Location key;

    public BaseMapWithCompsState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step == tree.getChildCount())
        {
            setResult(new ExecutionResult(generator.generate(mapping)));
            return null;
        }

        return request(tree.getChild(step++));
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (step % 2 == 1)
        {
            key = generator.generate(result.getValue().toRValue());
        }
        else
        {
            mapping.put(key, generator.generate(result.getValue().toRValue()));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BaseMapWithCompsState copy = new BaseMapWithCompsState(tree, payload.clone(sm));
        copy.mapping = (AlkMap) this.mapping.weakClone(sm.getLocationMapper());
        copy.step = this.step;
        copy.key = key != null ? sm.getLocationMapper().get(key) : null;
        return super.decorate(copy, sm);
    }
}
