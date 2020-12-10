package ast.state;

import ast.Payload;
import ast.Result;
import ast.State;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class IndependentSingleState<T extends Payload, S extends Result<?>> extends State<T, S>
{
    private ParseTree dependency;
    private boolean visited = false;
    private Class<? extends alkBaseVisitor> visitor;

    public IndependentSingleState(ParseTree ctx, Class<? extends alkBaseVisitor> visitor, ParseTree dependency, T payload)
    {
        super(ctx, payload);
        this.dependency = dependency;
        this.visitor = visitor;
    }

    @Override
    public State<T, S> makeStep()
    {
        if (visited)
        {
            return null;
        }

        visited = true;
        return request(visitor, dependency);
    }

    @Override
    public void assign(S result)
    {
        setResult(result);
    }
}
