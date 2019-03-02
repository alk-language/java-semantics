package impl.visitors.function;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.alkNotAValue.AlkNotAValue;
import impl.types.alkSet.AlkSet;
import impl.visitors.expression.ExpressionVisitor;

import java.util.ArrayList;

import static impl.exceptions.AlkException.*;
import static impl.types.alkNotAValue.AlkNotAValue.NO_RETURN;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env) {
        this.env = env;
    }


    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) { // momentan este doar printul TODO de analizat
        int size = ctx.expression().size();
        String name = ctx.method_name().start.getText();
        ArrayList<AlkValue> params = new ArrayList<>();
        for (int i=0; i<size; i++)
        {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
            params.add(((AlkValue)expressionVisitor.visit(ctx.expression(i))).clone());
        }
        try {
            switch (name)
            {
                case "print": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); System.out.println(params.get(0).toString()); return new AlkNotAValue(NO_RETURN);
                case "singletonSet": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); AlkSet set = new AlkSet(); set.insert(params.get(0)); return set;
                case "int": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return Convertors.toInt(params.get(0));
                case "float": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return Convertors.toFloat(params.get(0));
                case "random": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return NonDeterministic.get(params.get(0));
                default: throw new AlkException(ERR_FUNCTION_UNDEFINED);
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
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