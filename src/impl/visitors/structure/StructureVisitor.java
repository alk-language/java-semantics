package impl.visitors.structure;

import grammar.alkBaseVisitor;
import impl.env.Environment;

import java.util.HashMap;

public class StructureVisitor extends alkBaseVisitor {

    protected Environment env;

    public StructureVisitor(Environment env) {
        this.env = env;
    }
}
