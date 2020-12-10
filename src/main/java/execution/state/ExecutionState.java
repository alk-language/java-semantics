package execution.state;

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
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import util.*;
import util.lambda.LocationGenerator;
import util.types.Value;

/**
 * @param <T>
 *        What does the execution state return
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class ExecutionState<T extends Value, S extends Value> extends State<ExecutionPayload, ExecutionResult<T>>
{
    protected LocationGenerator generator;

    public ExecutionState(ParseTree tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        generator = (Value value) -> getStore().malloc().assign(value);
    }

    public abstract ExecutionState makeStep();

    public abstract ExecutionState clone(SplitMapper sm);

    protected Environment getEnv()
    {
        return payload.getEnvManager().getEnv(this);
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


    protected ExecutionState decorate(ExecutionState copy, SplitMapper sm)
    {
        if (getResult() != null)
        {
            copy.setResult(getResult().clone(sm.getLocationMapper()));
        }
        return copy;
    }

    @Override
    public ExecutionState request(Class<? extends alkBaseVisitor> visitor, ParseTree parseTree)
    {
        return request(visitor, parseTree, (Value) null);
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor, ParseTree parseTree, Value value)
    {
        return request(visitor, parseTree, getEnv(), value);
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor, ParseTree parseTree, Environment env)
    {
        return request(visitor, parseTree, env, (Value) null);
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor,
                                               ParseTree parseTree,
                                               Environment env,
                                               Value value)
    {
        ExecutionPayload nxt = new ExecutionPayload(getExec(), value);
        return request(visitor, parseTree, env, nxt);
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor,
                                               ParseTree parseTree,
                                               Environment env,
                                               ExecutionPayload executionPayload)
    {
        return (ExecutionState) VisitorFactory.create(visitor, env, executionPayload).visit(parseTree);
    }

    public boolean handle(AlkException e)
    {
        ParserRuleContext prc = (ParserRuleContext) tree;
        if (e.isUnsigned())
            throw new AlkException(prc.start.getLine(), e.getMessage());
        throw e;
    }
}
