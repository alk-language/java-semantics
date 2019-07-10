package impl.visitors.function;


import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.alkNotAValue.AlkNotAValue;
import impl.types.alkSet.AlkSet;
import impl.visitors.expression.ExpressionVisitor;
import impl.visitors.helpers.Convertors;
import impl.visitors.helpers.MathHelper;
import impl.visitors.helpers.NonDeterministic;


import java.util.ArrayList;

import static impl.exceptions.AlkException.*;
import static impl.types.alkNotAValue.AlkNotAValue.NO_RETURN;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env) {
        this.env = env;
    }


    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
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
                case "print": if (params.size()!=1)
                    throw new AlkException(ERR_PARAM_NUMBER);
                System.out.println(params.get(0).toString());
                return new AlkNotAValue(NO_RETURN);
                case "singletonSet": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); AlkSet set = new AlkSet(); set.insert(params.get(0)); return set;
                case "int": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return Convertors.toInt(params.get(0));
                case "float": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return Convertors.toFloat(params.get(0));
                case "random": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return NonDeterministic.getRandom(params.get(0));

                //Math functions
                case "sin": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.sin(params.get(0));
                case "cos": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.cos(params.get(0));
                case "tan": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.tan(params.get(0));
                case "asin": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.asin(params.get(0));
                case "acos": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.acos(params.get(0));
                case "atan": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.atan(params.get(0));
                case "log": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.log(params.get(0));
                case "pow": if (params.size()!=2) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.pow(params.get(0), params.get(1));
                case "sqrt": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.sqrt(params.get(0));
                case "pi": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.pi();
                case "abs": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return MathHelper.abs(params.get(0));

                //String functions
                case "len": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); return params.get(0).len();

                default: throw new AlkException(ERR_FUNCTION_UNDEFINED);
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        } catch (InterpretorException e) {
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
                    AlkValue val = (AlkValue) expressionVisitor.visit(ctx.expression(i));
                    array.add(val.clone());
                }
            }
            return function.call(array);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
    }
}