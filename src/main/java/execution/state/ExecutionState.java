package execution.state;

import execution.Execution;
import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.env.EnvironmentImpl;
import parser.env.Store;
import execution.types.AlkValue;
import parser.exceptions.AlkException;
import parser.exceptions.UnwindException;
import util.*;
import util.lambda.LocationGenerator;
import util.types.Value;

/**
 * @param <T>
 *        What does the execution state return
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class ExecutionState<T extends Value, S extends Value> implements Cloneable
{
    protected ParseTree tree;

    protected ExecutionResult result = null;

    private Payload payload;

    protected LocationGenerator generator;

    public ExecutionState(ParseTree tree, Payload payload)
    {
        this.tree = tree;
        this.payload = payload;
        generator = (AlkValue value) -> getStore().malloc().assign(value);
    }

    public ExecutionResult getResult()
    {
        return result;
    }

    public abstract ExecutionState<S, ? extends Value> makeStep();

    public abstract void assign(ExecutionResult<S> result);

    public abstract ExecutionState clone(SplitMapper sm);

    protected Environment getEnv()
    {
        return payload.getEnvManager().getEnv(this);
    }

    protected Store getStore()
    {
        return payload.getExecution().getStore();
    }

    protected Configuration getConfig() { return payload.getConfiguration(); }

    protected Execution getExec() { return payload.getExecution(); }

    protected FuncManager getFuncManager() { return payload.getExecution().getFuncManager(); }

    protected Environment getGlobal() { return payload.getExecution().getGlobal(); }

    protected AlgorithmTypeDetector getAlgorithmTypeDetector() { return payload.getExecution().getConfiguration(); }


    protected ExecutionState decorate(ExecutionState copy, SplitMapper sm)
    {
        if (result != null)
        {
            copy.result = result.clone(sm.getLocationMapper());
        }
        return copy;
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor, ParseTree parseTree)
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
        Payload nxt = new Payload(payload.getExecution(), value);
        return request(visitor, parseTree, env, nxt);
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor,
                                               ParseTree parseTree,
                                               Environment env,
                                               Payload payload)
    {
        return (ExecutionState) VisitorFactory.create(visitor, env, payload).visit(parseTree);
    }

    public boolean handle(UnwindException u)
    {
        return false;
    }

    public boolean handle(AlkException e)
    {
        ParserRuleContext prc = (ParserRuleContext) tree;
        if (e.isUnsigned())
            throw new AlkException(prc.start.getLine(), e.getMessage());
        throw e;
    }
}
