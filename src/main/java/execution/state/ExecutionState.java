package execution.state;

import execution.Execution;
import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.env.Store;
import execution.types.AlkValue;
import util.Configuration;
import util.Payload;
import util.VisitorFactory;
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

    protected ExecutionResult<T> result = null;

    private Payload payload;

    protected LocationGenerator generator;

    public ExecutionState(ParseTree tree, Payload payload)
    {
        this.tree = tree;
        this.payload = payload;
        generator = (AlkValue value) -> getStore().malloc().assign(value);
    }

    public ExecutionResult<T> getResult()
    {
        return result;
    }

    public abstract ExecutionState<S, ? extends Value> makeStep();

    public abstract void assign(ExecutionResult<S> result);

    public abstract ExecutionState clone(Payload payload);

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

    protected ExecutionState decorate(ExecutionState copy)
    {
        if (result != null)
        {
            copy.result = result.clone();
        }
        return copy;
    }

    protected ExecutionState<S, Value> request(Class<? extends alkBaseVisitor> visitor, ParseTree parseTree)
    {
        return (ExecutionState) VisitorFactory.create(visitor, getEnv(), payload).visit(parseTree);
    }
}
