package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.SingleState;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkStructure;
import ro.uaic.info.alk.util.types.Storable;

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