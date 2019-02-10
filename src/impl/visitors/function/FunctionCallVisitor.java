package impl.visitors.function;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.util.ArrayList;

import static impl.exceptions.AlkException.ERR_PARAM_NOT_DEFINED;
import static impl.exceptions.AlkException.ERR_PRINT_PARAM;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env) {
        this.env = env;
    }


    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) { // momentan este doar printul TODO de analizat
        if (ctx.expression().size()!=1)
        {
            AlkException e = new AlkException(ERR_PRINT_PARAM);
            e.printException(ctx.start.getLine());
            return null;
        }
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        System.out.println(((AlkValue)exprVisitor.visit(ctx.expression(0))).toString());
        return null;
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx) {
        try {
            AlkFunction function = AlkFunction.get(ctx.ID().getText(), ctx.expression().size());
            ArrayList array = new ArrayList();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
                if (function.isOut(i))
                {
                    String nume = ctx.expression(i).getText();
                    if (!env.has(nume))
                        throw new AlkException(ERR_PARAM_NOT_DEFINED);
                    array.add(new AlkInt(env.getLocation(nume)));
                }
                else
                {
                    array.add(expressionVisitor.visit(ctx.expression(i)));
                }
            }
            return function.call(array);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
    }
}