package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.env.*;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.ReturnException;
import execution.parser.exceptions.UnwindException;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.functions.Parameter;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

@CtxState(ctxClass = alkParser.DefinedFunctionCallContext.class)
public class DefinedFunctionCallState extends ExecutionState<Value, Value> {

    alkParser.DefinedFunctionCallContext ctx;
    List<Value> params = new ArrayList<>();
    AlkFunction function;
    int step = 0;
    boolean executed = false;
    Environment env;

    public DefinedFunctionCallState(alkParser.DefinedFunctionCallContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload);
        this.ctx = ctx;
        function = getFuncManager().getFunction(ctx.ID().getText());
        env = new EnvironmentImpl(getStore());
        if (ctx.expression().size() != function.countParams())
            super.handle(new AlkException(ctx.start.getLine(), "Invalid number of arguments passed to the function"));
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

            return request(StmtVisitor.class, function.getBody(), env);
        }
        return null;
    }

    @Override
    public boolean handle(UnwindException e)
    {
        if (e instanceof ReturnException)
        {
            setResult(new ExecutionResult(((ReturnException) e).getValue()));
            return true;
        }
        return false;
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        if (!executed)
        {
            Value value = executionResult.getValue();
            Parameter param = function.getParam(step - 1);
            if (param.isOut())
                params.add(value.toLValue());
            else
                params.add(value.toRValue());
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        DefinedFunctionCallState copy = new DefinedFunctionCallState(ctx, sm.getExecutionPayload());
        for (Value param : params)
        {
            copy.params.add(param.weakClone(sm.getLocationMapper()));
        }
        copy.function = function.clone(sm);
        copy.step = step;
        copy.executed = executed;
        copy.env = sm.getEnvironmentMapper().get(this.env);
        return super.decorate(copy, sm);
    }
}