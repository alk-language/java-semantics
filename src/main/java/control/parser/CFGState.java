package control.parser;

import ast.AST;
import control.Edge;
import control.Node;
import state.State;
import control.ControlFlowGraph;

import java.util.Collections;
import java.util.List;

public abstract class CFGState extends State<CFGPayload, CFGResult>
{
    public CFGState(AST tree, CFGPayload payload)
    {
        // to be resolved
        super(tree, payload, payload.getInterpreterManager());
    }

    protected void link(Edge inputEdge, Node node)
    {
        link(Collections.singletonList(inputEdge), node);
    }

    protected void link(List<Edge> inputEdges, Node node)
    {
        for (Edge edge : inputEdges)
        {
            edge.setOutput(node);
            node.appendInput(edge);
        }
    }
}
