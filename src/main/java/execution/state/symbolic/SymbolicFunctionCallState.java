package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.enums.ParamType;
import ast.expr.SymIDAST;
import ast.type.DataTypeAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.*;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.state.function.DefinedFunctionCallState;
import execution.types.alkBool.AlkBool;
import execution.types.alkNotAValue.AlkNotAValue;
import symbolic.SymbolicValue;
import util.functions.Parameter;
import util.types.Storable;

public class SymbolicFunctionCallState
extends DefinedFunctionCallState
{
    private int stepReq = 0;
    private int stepEns = 0;
    private boolean doneHavoc = false;
    private boolean envUpdate = false;

    public SymbolicFunctionCallState(AST tree, ExecutionPayload executionPayload)
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

        if (tree.getChildCount() != function.countParams())
        {
            super.handle(new AlkException( "Invalid number of arguments passed to the function."));
        }

        env = new EnvironmentImpl(getStore());

        setResult(new ExecutionResult(new AlkNotAValue()));
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step < tree.getChildCount())
        {
            return request(tree.getChild(step));
        }

        if (!envUpdate)
        {
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
            }
            envUpdate = true;
        }

        // TODO: consider modifies
        if (stepReq < function.getRequires().size())
        {
            return request(function.getRequires().get(stepReq), env);
        }

        if (!doneHavoc)
        {
            doneHavoc = true;
            // havoc output
            for (Parameter param : function.getParams())
            {
                if (param.getType().equals(ParamType.OUTPUT))
                {
                    DataTypeAST dataType = param.getDataType();
                    AST symAST = SymIDAST.generate(param.getName());
                    env.getLocation(param.getName()).setValue(new SymbolicValue(symAST));
                    getExec().getPathCondition().setType(symAST.getText(), dataType, true);
                }
            }

            DataTypeAST dataType = function.getDataType();
            if (dataType == null)
            {
                throw new AlkException("Can't detect the return data type of the function: " + function.getName());
            }
            AST symAST = SymIDAST.generate(SymbolicResultState.resultName);
            env.define(SymbolicResultState.resultName).setValue(new SymbolicValue(symAST));
            getExec().getPathCondition().setType(symAST.getText(), dataType, true);
        }

        if (stepEns < function.getEnsures().size())
        {
            return request(function.getEnsures().get(stepEns), env);
        }

        setResult(new ExecutionResult(env.getLocation(SymbolicResultState.resultName).toRValue()));
        return null;
    }

    private void processRequires(Storable value)
    {
        if (value instanceof SymbolicValue)
        {
            if (!getExec().getPathCondition().asserts((SymbolicValue) value))
            {
                super.handle(new AlkException("The path condition doesn't assert the precondition of " + function.getName()));
            }
        }
        else if (value instanceof AlkBool)
        {
            if (!((AlkBool) value).isTrue())
            {
                super.handle(new AlkException("The path condition doesn't assert the precondition of " + function.getName()));
            }
        }
        else
        {
            super.handle(new AlkException("Invalid data type for precondition value: " + value));
        }
    }

    private void processEnsures(Storable value)
    {
        if (value instanceof SymbolicValue)
        {
            getExec().getPathCondition().add((SymbolicValue) value);
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("The path condition is not satisfiable after calling: " + function.getName()));
            }
        }
        else if (value instanceof AlkBool)
        {
            if (!((AlkBool) value).isTrue())
            {
                super.handle(new AlkException("The path condition is not satisfiable after calling " + function.getName()));
            }
        }
        else
        {
            super.handle(new AlkException("Invalid data type for postcondition value: " + value));
        }
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (step < tree.getChildCount())
        {
            checkNotNull(executionResult.getValue(), true);
            params.add(executionResult.getValue());
            step++;
        }
        else if (stepReq < function.getRequires().size())
        {
            stepReq++;
            processRequires(executionResult.getValue().toRValue());
        }
        else if (stepEns < function.getEnsures().size())
        {
            stepEns++;
            processEnsures(executionResult.getValue().toRValue());
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicFunctionCallState copy = new SymbolicFunctionCallState(tree, payload.clone(sm));
        copy.stepReq = stepReq;
        copy.stepEns = stepEns;
        copy.doneHavoc = doneHavoc;
        copy.envUpdate = envUpdate;
        return super.decorate(copy, sm);
    }
}
