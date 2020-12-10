package ast;

import execution.VisitorFactory;
import execution.parser.exceptions.UnwindException;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @param <T> payload type
 * @param <S> result type
 */
public abstract class State<T extends Payload, S extends Result<?>>
{
    protected ParseTree tree;

    protected S result = null;

    protected T payload;

    public State(ParseTree tree, T payload)
    {
        this.tree = tree;
        this.payload = payload;
    }

    public S getResult()
    {
        return result;
    }

    protected void setResult(S result)
    {
        this.result = result;
    }

    public T getPayload() {return payload;}

    public ParseTree getTree() {return tree;}

    public abstract State<T, S> makeStep();

    public abstract void assign(S result);

    public boolean handle(UnwindException u)
    {
        return false;
    }

    public State<T, S> request(Class<? extends alkBaseVisitor> visitor, ParseTree tree)
    {
        return request(visitor, tree, payload);
    }

    public State<T, S> request(Class<? extends alkBaseVisitor> visitor, ParseTree tree, T payload)
    {
        return (State<T, S>) VisitorFactory.create(visitor, payload, payload.getClass()).visit(tree);
    }
}
