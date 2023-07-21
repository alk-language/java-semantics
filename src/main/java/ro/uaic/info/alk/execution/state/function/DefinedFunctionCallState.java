package ro.uaic.info.alk.execution.state.function;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.enums.ParamType;
import ro.uaic.info.alk.util.Constants;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.AlkFunction;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.EnvironmentImpl;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.ReturnException;
import ro.uaic.info.alk.exeptions.UnwindException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.functions.Parameter;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class DefinedFunctionCallState
extends ExecutionState
{

    protected final List<Storable> params = new ArrayList<>();
    protected AlkFunction function;
    protected int step = 0;
    protected Environment env;

    private boolean madeEnv = false;
    private boolean executed = false;
    private int reqStep = 0;
    private int ensStep = 0;
    private String stringRepr = "function call";

    public DefinedFunctionCallState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        String id = tree.getAttribute(IdASTAttr.class).getId();

        try
        {
            function = getFuncManager().getFunction(id);
        }
        catch (NoSuchFunctionException e)
        {
            super.handle(e);
        }

        if (tree.getAttribute(IdASTAttr.class).getId().equals(Constants.MAIN_FNC))
        {
            env = getEnv();
        }
        else
        {
            env = new EnvironmentImpl(getStore());
            getExec().registerEnv(env);
        }

        if (tree.getChildCount() != function.countParams())
        {
            super.handle(new AlkException( "Invalid number of arguments passed to the function."));
        }

        setResult(new ExecutionResult(AlkNotAValue.INSTANCE));
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step < tree.getChildCount())
        {
            return request(tree.getChild(step));
        }

        if (!executed)
        {
            if (!madeEnv)
            {
                madeEnv = true;
                for (int i = 0; i < function.countParams(); i++)
                {
                    Parameter param = function.getParam(i);
                    if (param.getType() == ParamType.OUTPUT)
                    {
                        env.setLocation(param.getName(), params.get(i).toLValue());
                    }
                    else
                    {
                        env.update(param.getName(), params.get(i).toRValue().clone(generator));
                    }

                    env.define(OldState.oldName + "(" + param.getName() + ")").setValue(params.get(i).toRValue().clone(generator));
                }

                for (int i = 0; i < function.countModifies(); i++)
                {
                    String modify = function.getModify(i);
                    env.setLocation(modify, getGlobal().getLocation(modify));
                }
            }

            if (reqStep < function.getRequires().size())
            {
                return request(function.getRequires().get(reqStep), env);
            }

            List<String> paramValues = new ArrayList<>();
            for (Parameter p : function.getParams())
            {
                paramValues.add(p.getName() + " = " + env.getLocation(p.getName()).getValue());
            }
            stringRepr = function.getName() + "(" + String.join(", ", paramValues) + ")";
            getExec().getCallStack().push(this);

            return request(function.getBody(), env);
        }

        if (ensStep < function.getEnsures().size())
        {
            return request(function.getEnsures().get(ensStep), env);
        }

        getExec().getCallStack().pop();
        getExec().deregisterEnv(env);
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!madeEnv)
        {
            checkNotNull(executionResult.getValue(), true);
            params.add(executionResult.getValue());
            step++;
        }
        else if (reqStep < function.getRequires().size())
        {
            reqStep++;
            if (executionResult.getValue().toRValue() instanceof AlkBool)
            {
                if (!((AlkBool) executionResult.getValue().toRValue()).isTrue())
                {
                    throw new AlkException("Precondition doesn't hold!");
                }
            }
            else
            {
                throw new AlkException("The precondition value must be boolean!");
            }
        }
        else if (!executed)
        {
            executed = true;
        }
        else if (ensStep < function.getEnsures().size())
        {
            ensStep++;
            if (executionResult.getValue().toRValue() instanceof AlkBool)
            {
                if (!((AlkBool) executionResult.getValue().toRValue()).isTrue())
                {
                    throw new AlkException("Postcondition doesn't hold!");
                }
            }
            else
            {
                throw new AlkException("The postcondition value must be boolean!");
            }
        }
    }

    @Override
    public boolean handle(UnwindException e)
    {
        if (e instanceof ReturnException)
        {
            executed = true;
            setResult(new ExecutionResult(((ReturnException) e).getValue()));
            return true;
        }
        return false;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        DefinedFunctionCallState copy = new DefinedFunctionCallState(tree, payload.clone(sm));
        return this.decorate(copy, sm);
    }

    public ExecutionState decorate(DefinedFunctionCallState copy, SplitMapper sm)
    {
        for (Storable param : params)
        {
            copy.params.add(param.weakClone(sm.getLocationMapper()));
        }
        copy.function = function.clone(sm);
        copy.step = step;
        copy.executed = executed;
        copy.env = sm.getEnvironmentMapper().get(this.env);
        copy.madeEnv = madeEnv;
        copy.reqStep = reqStep;
        copy.stringRepr = stringRepr;
        return super.decorate(copy, sm);
    }

    @Override
    public String toString()
    {
        return stringRepr;
    }
}