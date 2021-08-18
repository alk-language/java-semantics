package execution.state.expression;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.AlkValue;
import execution.types.alkStructure.AlkStructure;
import util.types.Storable;

public class BaseDotOperatorState
extends SingleState
{
    private final String id;

    public BaseDotOperatorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
        this.id = tree.getAttribute(IdASTAttr.class).getId();
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        Location reference = value.toLValue();
        if (reference.isUnknown())
        {
            reference.setValue(new AlkStructure());
        }

        return ((AlkValue) reference.toRValue()).dot(id, generator);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseDotOperatorState copy = new BaseDotOperatorState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}