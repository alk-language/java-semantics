package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import execution.types.alkStructure.AlkStructure;
import parser.env.Location;
import parser.visitors.structure.DataStructureVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.ComponentValue;

@CtxState(ctxClass = alkParser.StructureWithComponentsContext.class)
public class StructureWithComponentsState extends GeneratorState<Location, ComponentValue>
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
    public Location getFinalResult()
    {
        return generator.generate(struct);
    }
    @Override
    public ExecutionState clone(SplitMapper sm) {
        StructureWithComponentsState copy = new StructureWithComponentsState(ctx, sm.getPayload());
        copy.struct = (AlkStructure) this.struct.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
