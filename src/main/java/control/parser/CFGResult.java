package control.parser;

import control.Edge;
import state.Result;
import control.ControlFlowGraph;
import util.exception.InternalException;

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
