package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import execution.types.alkStructure.AlkStructure;
import execution.parser.env.Location;
import execution.parser.visitors.structure.DataStructureVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.ComponentValue;

@CtxState(ctxClass = alkParser.StructureWithComponentsContext.class)
public class StructureWithComponentsState extends GeneratorState<Location, ComponentValue>
{
    private AlkStructure struct = new AlkStructure();

    alkParser.StructureWithComponentsContext ctx;

    public StructureWithComponentsState(alkParser.StructureWithComponentsContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.component(), DataStructureVisitor.class);
        ctx = tree;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        struct.insert((ComponentValue) executionResult.getValue());
    }

    @Override
    public Location getFinalResult()
    {
        return generator.generate(struct);
    }
    @Override
    public ExecutionState clone(SplitMapper sm) {
        StructureWithComponentsState copy = new StructureWithComponentsState(ctx, sm.getExecutionPayload());
        copy.struct = (AlkStructure) this.struct.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
