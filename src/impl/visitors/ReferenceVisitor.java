package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.alkBool.AlkBool;
import impl.types.AlkValue;

public class ReferenceVisitor extends alkBaseVisitor {

    private Environment env;

    public ReferenceVisitor(Environment env) {
        this.env = env;
    }


    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        String name = ctx.ID().toString();
        AlkValue value;
        try {
            value = env.lookup(name);
            return value;
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return new AlkBool(false);
    }
}
