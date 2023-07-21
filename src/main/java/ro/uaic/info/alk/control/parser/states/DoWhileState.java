package ro.uaic.info.alk.control.parser.states;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.control.ConditionalEdgeData;
import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.control.Node;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.control.parser.CFGPayload;
import ro.uaic.info.alk.control.parser.CFGResult;
import ro.uaic.info.alk.control.parser.CFGState;

import java.util.List;

public class DoWhileState
extends CFGState
{
    Node node;
    int visited = 0;
    List<Edge> terminals;

    public DoWhileState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new Node(tree.getChild(0));
        node.forceText("do-while (" + node.toString() + ")");
        node.setLoop(true);
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (visited == 0)
        {
            visited = 1;
            return request(tree.getChild(0), payload);
        }

        if (visited == 1)
        {
            visited = 2;
            Edge edge = new Edge(node, null, new ConditionalEdgeData(true));
            node.appendOutput(edge);
            return request(tree.getChild(1), new CFGPayload(edge, payload.getInterpreterManager()));
        }

        Edge edge = new Edge(node, null, new ConditionalEdgeData(false));
        node.appendOutput(edge);
        setResult(new CFGResult(edge));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        terminals = result.getValue();
        link(terminals, node);
    }
}
