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
    private boolean checkKey = true;

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

        if (checkKey)
        {
            return request(tree.getChild(step).getChild(0));
        }
        else
        {
            return request(tree.getChild(step).getChild(1));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (checkKey)
        {
            key = generator.generate(result.getValue().toRValue());
            checkKey = false;
        }
        else
        {
            mapping.put(key, generator.generate(result.getValue().toRValue()));
            checkKey = true;
            step++;
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BaseMapWithCompsState copy = new BaseMapWithCompsState(tree, payload.clone(sm));
        copy.mapping = (AlkMap) this.mapping.weakClone(sm.getLocationMapper());
        copy.step = this.step;
        copy.key = key != null ? sm.getLocationMapper().get(key) : null;
        copy.checkKey = checkKey;
        return super.decorate(copy, sm);
    }
}
