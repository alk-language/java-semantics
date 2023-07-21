package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.Collections;
import java.util.List;

public class CFGResult
extends Result<List<Edge>>
{
    public CFGResult(List<Edge> value)
    {
        super(value);
        if (value.isEmpty())
        {
            throw new InternalException("The CFG state should have at least one terminal node.");
        }
    }

    public CFGResult(Edge value)
    {
        this(Collections.singletonList(value));
    }
}
