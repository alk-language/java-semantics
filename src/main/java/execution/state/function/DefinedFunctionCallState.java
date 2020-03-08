package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import parser.env.AlkFunction;
import parser.env.Environment;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.functions.Parameter;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

@CtxState(ctxClass = alkParser.DefinedFunctionCallContext.class)
public class DefinedFunctionCallState extends ExecutionState {

    alkParser.DefinedFunctionCallContext ctx;
    List<Value> params = new ArrayList<>();
    AlkFunction function;
    int step = 0;
    boolean executed = false;
    Environment env;

    public DefinedFunctionCallState(alkParser.DefinedFunctionCallContext ctx, Payload payload) {
        super(ctx, payload);
        this.ctx = ctx;
        function = getFuncManager().getFunction(ctx.ID().getText());
        env = new Environment(getStore());
        if (ctx.expression().size() != function.countParams())
            throw new AlkException(ctx.start.getLine(), "Invalid number of arguments passed to the function");
    }

    @Override
    public ExecutionState makeStep() {
        if (step < ctx.expression().size())
        {
            return request(ExpressionVisitor.class, ctx.expression(step++));
        }
        if (!executed)
        {
            executed = true;

            for (int i=0; i<function.countParams(); i++)
            {
                Parameter param = function.getParam(i);
                if (param.isOut())
                    env.setLocation(param.getName(), (Location) params.get(i));
                else
                    env.update(param.getName(), (AlkValue) params.get(i));
            }

            for (int i=0; i<function.countModifies(); i++)
            {
                String modify = function.getModify(i);
                env.setLocation(modify, getGlobal().getLocation(modify));
            }

            return request(StmtVisitor.class, function.getBody(), env, (Value) null);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult result) {
        if (!executed)
        {
            Value value = result.getValue();
            Parameter param = function.getParam(step - 1);
            if (param.isOut())
                params.add(value.toLValue());
            else
                params.add(value.toRValue());
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        return null;
    }
}


        /*try {
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
        }*/