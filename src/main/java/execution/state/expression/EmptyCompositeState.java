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
import execution.types.alkStructure.AlkStructure;
import util.exception.InternalException;
import util.types.Storable;

public class EmptyCompositeState
extends PrimitiveState
{
    Primitive primitive;

    public EmptyCompositeState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
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
            case STRUCTURE:
                return new AlkStructure();
            default:
                throw new InternalException("Unrecognized primitive type for this compound representation!");
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptyCompositeState copy =  new EmptyCompositeState(primitive, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
