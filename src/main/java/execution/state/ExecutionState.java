package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.types.AlkValue;
import util.types.Value;

/**
 * TODO: make execution state independent from the visitor: use a the execution stack for global configurations
 * @param <T>
 *        What does the execution state return
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class ExecutionState<T extends Value, S extends Value>
{

    protected ParseTree tree;
    protected alkBaseVisitor visitor;
    protected ExecutionResult<T> result = null;

    // TODO: remove the env variable, make it accessible in another way
    protected Environment env;

    public ExecutionState(ParseTree tree, alkBaseVisitor visitor)
    {
        this.tree = tree;
        this.visitor = visitor;
    }

    public ExecutionResult<T> getResult()
    {
        return result;
    }

    public abstract ExecutionState<S, ? extends Value> makeStep();

    public abstract void assign(ExecutionResult<S> result);

    protected Environment getEnv()
    {
        return env;
    }

    protected void setEnv(Environment e)
    {
        env = e;
    }
}
