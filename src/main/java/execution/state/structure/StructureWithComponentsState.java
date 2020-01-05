package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkStructure.AlkStructure;
import parser.visitors.structure.DataStructureVisitor;
import parser.visitors.structure.StructureVisitor;
import util.CtxState;
import util.Payload;
import util.types.ComponentValue;
import util.types.Value;

@CtxState(ctxClass = alkParser.StructureWithComponentsContext.class)
public class StructureWithComponentsState extends GeneratorState<AlkStructure, ComponentValue>
{

    private AlkStructure struct = new AlkStructure();

    alkParser.StructureWithComponentsContext ctx;

    public StructureWithComponentsState(alkParser.StructureWithComponentsContext tree, Payload payload) {
        super(tree, payload, tree.component(), DataStructureVisitor.class);
        ctx = tree;
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
    @Override
    public ExecutionState clone(Payload payload) {
        StructureWithComponentsState copy = new StructureWithComponentsState(ctx, payload);
        copy.struct = (AlkStructure) this.struct.clone();
        return super.decorate(copy);
    }
}
