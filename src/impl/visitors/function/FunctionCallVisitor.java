package impl.visitors.function;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.alkBool.AlkBool;
import impl.visitors.expression.ExpressionVisitor;

import java.util.ArrayList;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env) {
        this.env = env;
    }

    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        return new AlkBool(false);
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx) {
        try {
            AlkFunction function = AlkFunction.get(ctx.ID().getText(), ctx.expression().size());
            ArrayList array = new ArrayList();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
                array.add(expressionVisitor.visit(ctx.expression(i)));
            }
            return function.call(array);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
    }



}