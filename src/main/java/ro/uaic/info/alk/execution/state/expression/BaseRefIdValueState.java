package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.state.ExecutionState;

public class BaseRefIdValueState
   extends ExecutionState
{
    private String id;

    public BaseRefIdValueState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.id = tree.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public ExecutionState makeStep()
    {
        Environment env = getEnv();
        if (env.has(this.id))
        {
            setResult(new ExecutionResult(env.getLocation(this.id)));
        }
        else
        {
            setResult(new ExecutionResult(env.define(this.id)));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseRefIdValueState copy = new BaseRefIdValueState(tree, payload.clone(sm));
        copy.id = id;
        return super.decorate(copy, sm);
    }
}