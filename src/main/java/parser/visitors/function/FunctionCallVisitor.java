package parser.visitors.function;


import execution.state.ExecutionState;
import execution.state.function.BuiltInMethodState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.AlkFunction;
import parser.env.Environment;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;


import java.util.ArrayList;

import static parser.exceptions.AlkException.*;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionCallVisitor(Environment env)
    {
        this.env = env;
    }

    public Environment getEnvironment()
    {
        return env;
    }


    @Override
    public ExecutionState visitBuiltinMethod(alkParser.BuiltinMethodContext ctx)
    {
        return new BuiltInMethodState(ctx, this);
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx)
    {
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