package control.parser;

import state.Payload;
import control.ControlFlowGraph;
import visitor.stateful.StatefulInterpreterManager;

import java.util.Collections;
import java.util.List;

public class CFGPayload extends Payload
{
    List<ControlFlowGraph.Node> inputs;
    StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager;

    public CFGPayload(List<ControlFlowGraph.Node> inputs, StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager)
    {
        this.inputs = inputs;
        this.interpreterManager = interpreterManager;
    }

    public CFGPayload(ControlFlowGraph.Node input, StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager)
    {
        this.inputs = Collections.singletonList(input);
        this.interpreterManager = interpreterManager;
    }

    public List<ControlFlowGraph.Node> getInputs()
    {
        return this.inputs;
    }

    public StatefulInterpreterManager<CFGPayload, CFGResult,?> getInterpreterManager()
    {
        return interpreterManager;
    }
}
