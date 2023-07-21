package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.LoopingState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class ForEachState
extends LoopingState
{
    private List<Storable> source;
    private int step = 0;
    private String id;

    public ForEachState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0), tree.getChild(1));
        this.id = tree.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (source == null)
        {
            return request(tree.getChild(0));
        }

        if (step == source.size())
        {
            return null;
        }

        getEnv().update(id, source.get(step).toRValue().clone(generator));
        step++;
        return request(tree.getChild(1));
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (source == null)
        {
            Storable value = executionResult.getValue().toRValue();
            if (value instanceof AlkIterableValue)
            {
                source = ((AlkIterableValue) value).toArray();
            }
            else
            {
                super.handle(new AlkException(AlkException.ERR_FORALL_ITERABLE_REQUIRED));
            }

        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ForEachState copy = new ForEachState(tree, payload.clone(sm));
        return this.decorate(copy, sm);
    }

    public ExecutionState decorate(ForEachState copy, SplitMapper sm)
    {
        copy.step = this.step;
        if (this.source != null)
        {
            for (Storable loc : source)
            {
                copy.source.add(loc.weakClone(sm.getLocationMapper()));
            }
        }
        return super.decorate(copy, sm);
    }
}
