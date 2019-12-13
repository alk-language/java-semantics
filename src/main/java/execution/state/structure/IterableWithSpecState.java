package execution.state.structure;

import execution.state.SingleState;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkIterableValue;
import parser.types.alkArray.AlkArray;
import parser.visitors.structure.DataStructureVisitor;
import util.Payload;
import util.exception.InternalException;

public class IterableWithSpecState extends SingleState<AlkIterableValue, AlkArray> {

    private final Class<? extends AlkIterableValue> clazz;

    public IterableWithSpecState(ParseTree tree,
                                 Payload payload,
                                 ParseTree spec,
                                 Class<? extends AlkIterableValue> clazz)
    {
        super(tree, payload, spec, DataStructureVisitor.class);
        this.clazz = clazz;
    }

    @Override
    protected AlkIterableValue interpretResult(AlkArray value) {
        try {
            AlkIterableValue iterableValue = clazz.newInstance();
            iterableValue.addAll(value.toArray());
            return iterableValue;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new InternalException(e);
        }
    }
}
