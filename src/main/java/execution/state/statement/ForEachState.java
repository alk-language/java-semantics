package execution.state.statement;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.types.AlkIterableValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_FORALL_ITERABLE_REQUIRED;

@CtxState(ctxClass = alkParser.ForEachStructureContext.class)
public class ForEachState
extends LoopingState
{
    private List<Location> source;
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
            Value value = executionResult.getValue().toRValue();
            if (value instanceof AlkIterableValue)
            {
                source = ((AlkIterableValue) value).toArray();
            }
            else
            {
                super.handle(new AlkException(ERR_FORALL_ITERABLE_REQUIRED));
            }

        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ForEachState copy = new ForEachState(tree, payload.clone(sm));
        copy.step = this.step;
        for (Location loc : source)
        {
            copy.source.add(sm.getLocationMapper().get(loc));
        }
        return super.decorate(copy, sm);
    }
}
