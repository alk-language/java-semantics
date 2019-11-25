package execution.state.structure;

import execution.ExecutionResult;
import execution.state.GeneratorState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkStructure.AlkStructure;
import parser.visitors.structure.StructureVisitor;
import util.types.ComponentValue;
import util.types.Value;

public class StructureWithComponentsState extends GeneratorState<AlkStructure, ComponentValue>
{

    private AlkStructure struct = new AlkStructure();

    public StructureWithComponentsState(alkParser.StructureWithComponentsContext tree, StructureVisitor visitor) {
        super(tree, visitor, tree.component());
    }

    @Override
    public void assign(ExecutionResult<ComponentValue> result)
    {
        struct.insert(result.getValue());
    }

    @Override
    public AlkStructure getFinalResult()
    {
        return struct;
    }
}
