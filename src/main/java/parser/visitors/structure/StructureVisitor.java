package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.structure.StructureWithComponentsState;
import grammar.alkParser;
import parser.env.Environment;
import util.Payload;

public class StructureVisitor extends DataStructureVisitor {
    public StructureVisitor(Environment env, Payload payload) {
        super(env, payload);
    }

    public ExecutionState visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx)
    {
        return StateFactory.create(StructureWithComponentsState.class, ctx, payload, env);
    }
}
