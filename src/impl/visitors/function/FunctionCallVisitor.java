package impl.visitors.function;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env) {
        this.env = env;
    }

    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        return null;
    }

}