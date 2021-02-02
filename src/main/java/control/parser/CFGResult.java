package control.parser;

import state.Result;
import control.ControlFlowGraph;
import util.exception.InternalException;

import java.util.Collections;
import java.util.List;

public class CFGResult extends Result<List<ControlFlowGraph.Node>>
{
    public CFGResult(List<ControlFlowGraph.Node> value)
    {
        super(value);
        if (value.isEmpty())
            throw new InternalException("The CFG state should have at least one terminal node.");
    }

    public CFGResult(ControlFlowGraph.Node value)
    {
        this(Collections.singletonList(value));
    }
}
