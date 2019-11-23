package execution.state.structure;

import execution.state.SingleState;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkIterableValue;
import parser.types.alkArray.AlkArray;
import parser.visitors.structure.DataStructureVisitor;
import util.exception.InternalException;

public class IterableWithSpecState extends SingleState<AlkIterableValue, AlkArray> {

    private final Class<? extends AlkIterableValue> clazz;

    public IterableWithSpecState(ParseTree tree,
                                 DataStructureVisitor visitor,
                                 ParseTree spec,
                                 Class<? extends AlkIterableValue> clazz)
    {
        super(tree, visitor, spec);
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
