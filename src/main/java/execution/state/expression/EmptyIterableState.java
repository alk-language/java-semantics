package execution.state.expression;

import ast.AST;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkArray.AlkArray;
import execution.types.alkList.AlkList;
import execution.types.alkSet.AlkSet;
import util.exception.InternalException;
import util.types.Storable;

public class EmptyIterableState
extends PrimitiveState
{
    Primitive primitive;

    public EmptyIterableState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.primitive = primitive;
    }

    @Override
    protected Storable requireResult()
    {
        switch (this.primitive) {
            case ARRAY:
                return new AlkArray();
            case LIST:
                return new AlkList();
            case SET:
                return new AlkSet();
            default:
                throw new InternalException("Unrecognized primitive type for this compound representation!");
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptyIterableState copy =  new EmptyIterableState(primitive, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
