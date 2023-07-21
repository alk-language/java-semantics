package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.state.Payload;
import ro.uaic.info.alk.visitor.stateful.StatefulInterpreterManager;

import java.util.Collections;
import java.util.List;

public class CFGPayload extends Payload
{
    List<Edge> inputs;
    StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager;

    public CFGPayload(Edge input,
                      StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager)
    {
        this(Collections.singletonList(input), interpreterManager);
    }

    public CFGPayload(List<Edge> inputs,
                      StatefulInterpreterManager<CFGPayload, CFGResult,?> interpreterManager)
    {
        this.inputs = inputs;
        this.interpreterManager = interpreterManager;
    }

    public List<Edge> getInputs()
    {
        return this.inputs;
    }

    public StatefulInterpreterManager<CFGPayload, CFGResult,?> getInterpreterManager()
    {
        return interpreterManager;
    }
}
