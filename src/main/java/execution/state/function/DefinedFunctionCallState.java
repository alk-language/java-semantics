package execution.state.function;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkNotAValue.AlkNotAValue;
import execution.parser.env.*;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.ReturnException;
import execution.parser.exceptions.UnwindException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.functions.Parameter;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class DefinedFunctionCallState extends ExecutionState {

    private final List<Storable> params = new ArrayList<>();
    private AlkFunction function;
    private int step = 0;
    private boolean executed = false;
    private Environment env;

    public DefinedFunctionCallState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        String id = tree.getAttribute(IdASTAttr.class).getId();
        function = getFuncManager().getFunction(id);
        env = new EnvironmentImpl(getStore());

        if (tree.getChildCount() != function.countParams())
        {
            super.handle(new AlkException( "Invalid number of arguments passed to the function."));
        }

        setResult(new ExecutionResult(new AlkNotAValue()));
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step < tree.getChildCount())
        {
            return request(tree.getChild(step++));
        }

        if (!executed)
        {
            executed = true;

            for (int i = 0; i < function.countParams(); i++)
            {
                Parameter param = function.getParam(i);
                if (param.isOut())
                {
                    env.setLocation(param.getName(), params.get(i).toLValue());
                }
                else
                {
                    env.update(param.getName(), params.get(i).toRValue());
                }
            }

            for (int i = 0; i < function.countModifies(); i++)
            {
                String modify = function.getModify(i);
                env.setLocation(modify, getGlobal().getLocation(modify));
            }

            return request(function.getBody(), env);
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!executed)
        {
            params.add(executionResult.getValue());
        }
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
    public ExecutionState clone(SplitMapper sm)
    {
        DefinedFunctionCallState copy = new DefinedFunctionCallState(tree, payload.clone(sm));
        for (Storable param : params)
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