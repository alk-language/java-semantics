package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.StructureWithComponentsState;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.AlkValue;
import parser.types.alkStructure.AlkStructure;

public class StructureVisitor extends DataStructureVisitor {
    public StructureVisitor(Environment env) {
        super(env);
    }

    public ExecutionState visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx)
    {
        return new StructureWithComponentsState(ctx, this);
    }
}
