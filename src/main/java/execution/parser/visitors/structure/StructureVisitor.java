package execution.parser.visitors.structure;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.structure.StructureWithComponentsState;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.ExecutionPayload;

public class StructureVisitor extends DataStructureVisitor {
    public StructureVisitor(Environment env, ExecutionPayload executionPayload) {
        super(env, executionPayload);
    }

    public ExecutionState visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx)
    {
        return StateFactory.create(StructureWithComponentsState.class, ctx, executionPayload, env);
    }
}
