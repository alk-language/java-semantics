package ro.uaic.info.alk.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.UnwindException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.stateful.StatefulInterpreterManager;

/**
 * @param <T> payload type
 * @param <S> result type
 */
public abstract class State<T extends Payload, S extends Result<?>>
{
    protected final AST tree;

    protected final T payload;

    private final StatefulInterpreterManager<T, S, ?> interpreterManager;

    private S result = null;

    public State(AST tree, T payload, StatefulInterpreterManager<T, S, ?> interpreterManager)
    {
        this.tree = tree;
        this.payload = payload;
        this.interpreterManager = interpreterManager;
    }

    public abstract State<T, S> makeStep();

    public abstract void assign(S result);

    public boolean handle(UnwindException u)
    {
        return false;
    }

    public boolean handle(AlkException e)
    {
        return this.handle((InternalException) e);
    }

    public boolean handle(InternalException e)
    {
        if (e.getLine() == 0)
        {
            e.sign(tree.getLine(), tree.getColumn());
        }

        throw e;
    }

    public State<T, S> requestChild(int child)
    {
        return request(tree.getChild(child), payload);
    }

    public State<T, S> request(AST tree)
    {
        return request(tree, payload);
    }

    public State<T, S> request(AST tree, T payload)
    {
        return interpreterManager.interpret(tree, payload);
    }

    public AST getTree() {return tree;}

    public S getResult()
    {
        return result;
    }

    protected void setResult(S result)
    {
        this.result = result;
    }

    public T getPayload() {return payload;}
}
