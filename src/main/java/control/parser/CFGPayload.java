package control.parser;

import ast.Payload;
import control.ControlFlowGraph;

import java.util.Collections;
import java.util.List;

public class CFGPayload extends Payload
{
    List<ControlFlowGraph.Node> inputs;

    public CFGPayload(List<ControlFlowGraph.Node> inputs)
    {
        this.inputs = inputs;
    }

    public CFGPayload(ControlFlowGraph.Node input)
    {
        this.inputs = Collections.singletonList(input);
    }

    public List<ControlFlowGraph.Node> getInputs()
    {
        return this.inputs;
    }
}
