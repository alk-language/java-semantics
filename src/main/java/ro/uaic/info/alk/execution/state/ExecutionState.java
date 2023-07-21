package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.exeptions.UndefinedValueException;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.util.AlgorithmTypeDetector;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.FuncManager;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

public abstract class ExecutionState
extends State<ExecutionPayload, ExecutionResult>
{
    protected LocationGenerator generator;

    public ExecutionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, executionPayload.getExecution().getInterpreter());
        generator = (Storable value) -> getStore().generate(value);
    }

    public ExecutionState(ExecutionState copy, SplitMapper sm)
    {
        super(copy.getTree(), copy.getPayload().clone(sm), sm.getNewExecution().getInterpreter());
        generator = (Storable value) -> getStore().generate(value);
    }

    protected ExecutionState decorate(ExecutionState copy, SplitMapper sm)
    {
        if (getResult() != null)
        {
            copy.setResult(getResult().clone(sm.getLocationMapper()));
        }
        return copy;
    }

    public boolean handle(AlkException e)
    {
        e.setEnvironmentIfAbsent(getEnv());
        return super.handle(e);
    }

    public abstract ExecutionState makeStep();

    public abstract ExecutionState clone(SplitMapper sm);

    @Override
    public ExecutionState requestChild(int idx)
    {
        return (ExecutionState) super.requestChild(idx);
    }

    @Override
    public ExecutionState request(AST tree)
    {
        return (ExecutionState) super.request(tree);
    }

    protected ExecutionState request(AST tree, Environment env)
    {
        if (env == getEnv())
        {
            // avoid duplicating the payload if not absolutely necessarily
            return request(tree);
        }

        return (ExecutionState) super.request(tree, getPayload().duplicate(getExec(), env));
    }

    protected Environment getEnv()
    {
        return getPayload().getEnv();
    }

    protected StoreImpl getStore()
    {
        return getExec().getStore();
    }

    protected AlkConfiguration getConfig() { return getPayload().getConfiguration(); }

    protected AlkExecution getExec() { return getPayload().getExecution(); }

    protected FuncManager getFuncManager() { return getExec().getFuncManager(); }

    protected Environment getGlobal() { return getExec().getGlobal(); }

    protected AlgorithmTypeDetector getAlgorithmTypeDetector() { return getExec().getConfiguration(); }

    //TODO: remove
    @Deprecated
    protected void checkNotNull(Storable value, boolean unknownAllowed)
    {
        checkNotNull(value, unknownAllowed);
    }

    protected void checkNotNull(Storable value, boolean unknownAllowed, AST ast)
    {
        value = value == null ? null : value.toRValue();
        if (value == null || (!unknownAllowed && value instanceof AlkNotAValue))
        {
            throw new UndefinedValueException(ast);
        }
    }
}
