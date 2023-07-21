package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.control.Node;
import ro.uaic.info.alk.state.State;

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
