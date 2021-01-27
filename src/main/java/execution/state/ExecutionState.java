package execution.state;

import ast.AST;
import ast.State;
import execution.VisitorFactory;
import execution.Execution;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.env.Environment;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import util.*;
import util.lambda.LocationGenerator;
import util.types.Value;

public abstract class ExecutionState
extends State<ExecutionPayload, ExecutionResult>
{
    protected LocationGenerator generator;

    public ExecutionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, executionPayload.getExecution().getInterpreterManager());
        generator = (Value value) -> getStore().generate(value);
    }

    protected ExecutionState decorate(ExecutionState copy, SplitMapper sm)
    {
        if (getResult() != null)
        {
            copy.setResult(getResult().clone(sm.getLocationMapper()));
        }
        return copy;
    }

    public abstract ExecutionState makeStep();

    public abstract ExecutionState clone(SplitMapper sm);

    @Override
    public ExecutionState request(AST tree)
    {
        return request(tree, getEnv());
    }

    protected ExecutionState request(AST tree, Environment env)
    {
        return (ExecutionState) super.request(tree, new ExecutionPayload(getExec(), env));
    }

    public boolean handle(AlkException e)
    {
        if (e.isUnsigned())
        {
            throw new AlkException(tree.getLine(), e.getMessage());
        }
        throw e;
    }

    protected Environment getEnv()
    {
        return payload.getEnv();
    }

    protected StoreImpl getStore()
    {
        return getExec().getStore();
    }

    protected Configuration getConfig() { return payload.getConfiguration(); }

    protected Execution getExec() { return payload.getExecution(); }

    protected FuncManager getFuncManager() { return getExec().getFuncManager(); }

    protected Environment getGlobal() { return getExec().getGlobal(); }

    protected AlgorithmTypeDetector getAlgorithmTypeDetector() { return getExec().getConfiguration(); }
}
