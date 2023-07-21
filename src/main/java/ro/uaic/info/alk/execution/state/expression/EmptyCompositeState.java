package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.types.AlkMap;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkList;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.types.AlkStructure;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

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
                return getStore().generate(new AlkArray());
            case LIST:
                return getStore().generate(new AlkList());
            case SET:
                return getStore().generate(new AlkSet());
            case STRUCTURE:
                return getStore().generate(new AlkStructure());
            case MAP:
                return getStore().generate(new AlkMap());
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
