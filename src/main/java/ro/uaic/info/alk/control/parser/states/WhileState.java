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

public class WhileState extends CFGState
{
    AST ctx;
    Node node;
    boolean visited = false;

    public WhileState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new Node(tree.getChild(0)); // expression
        node.forceText("while (" + node.toString() + ")");
        node.setLoop(true);
        link(payload.getInputs(), node);
        this.ctx = tree;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visited)
        {
            visited = true;
            Edge edge = new Edge(node, null, new ConditionalEdgeData(true));
            node.appendOutput(edge);
            return request(ctx.getChild(1), new CFGPayload(edge, payload.getInterpreterManager()));
        }

        Edge edge = new Edge(node, null, new ConditionalEdgeData(false));
        node.appendOutput(edge);
        setResult(new CFGResult(edge));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        List<Edge> outputs = result.getValue();
        link(outputs, node);
    }
}
