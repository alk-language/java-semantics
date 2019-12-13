package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import util.Configuration;
import util.Payload;
import util.types.Value;

/**
 * TODO: make execution state independent from the visitor: use a the execution stack for global configurations
 * @param <T>
 *        What does the execution state return
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class ExecutionState<T extends Value, S extends Value> implements Cloneable
{
    protected ParseTree tree;

    // TODO: remove the visitor as global instance (not everybody needs a visitor
    // TODO: it shouldn't be initialized in the constructor (there is no unique visitor for one state
    // protected alkBaseVisitor visitor;

    protected ExecutionResult<T> result = null;
    protected Configuration config;
    protected Payload payload;

    public ExecutionState(ParseTree tree, Payload payload)
    {
        this.tree = tree;
        this.payload = payload;
    }

    public ExecutionResult<T> getResult()
    {
        return result;
    }

    public abstract ExecutionState<S, ? extends Value> makeStep();

    public abstract void assign(ExecutionResult<S> result);

    protected Environment getEnv()
    {
        return payload.getEnvManager().getEnv(this);
    }

    public void setConfiguration(Configuration config) {
        this.config = config;
    }
}
