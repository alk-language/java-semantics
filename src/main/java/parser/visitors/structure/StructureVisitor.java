package parser.visitors.structure;

import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.AlkValue;
import parser.types.alkStructure.AlkStructure;

public class StructureVisitor extends DataStructureVisitor {
    public StructureVisitor(Environment env) {
        super(env);
    }

    public AlkValue visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx) {
        AlkStructure struct = new AlkStructure();
        for (int i=0; i<ctx.component().size(); i++) {
            struct.insert((Pair) visit(ctx.component(i)));
        }
        return struct;
    }
}
