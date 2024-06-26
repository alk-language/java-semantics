package control.parser.states;

import ast.AST;
import control.ConditionalEdgeData;
import control.Edge;
import control.Node;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;

import java.util.ArrayList;
import java.util.List;

public class IfStmtState
extends CFGState
{
    Node node;
    boolean visitedLeft = false, visitedRight = false;
    List<Edge> outputs = new ArrayList<>();

    public IfStmtState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new Node(tree.getChild(0)); // expression
        node.forceText("if (" + node.toString() + ")");
        link(payload.getInputs(), node);
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visitedLeft)
        {
            visitedLeft = true;
            Edge edge = new Edge(node, null, new ConditionalEdgeData(true));
            node.appendOutput(edge);
            return request(tree.getChild(1), new CFGPayload(edge, payload.getInterpreterManager()));
        }
        if (tree.getChildCount() > 2 && !visitedRight)
        {
            visitedRight = true;
            Edge edge = new Edge(node, null, new ConditionalEdgeData(false));
            node.appendOutput(edge);
            return request(tree.getChild(2), new CFGPayload(edge, payload.getInterpreterManager()));
        }
        if (!visitedRight)
        {
            Edge edge = new Edge(node, null, new ConditionalEdgeData(false));
            node.appendOutput(edge);
            outputs.add(edge);
        }
        setResult(new CFGResult(outputs));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        outputs.addAll(result.getValue());
    }
}
