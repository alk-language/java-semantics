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

public class ForState extends CFGState
{
    Node initNode, condition, step;
    private boolean visited = false;

    public ForState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        initNode = new Node(tree.getChild(0)); // start-assignment
        link(payload.getInputs(), initNode);

        condition = new Node(tree.getChild(1)); // condition
        condition.setLoop(true);
        Edge edge = new Edge(initNode, null, null);
        initNode.appendOutput(edge);
        link(edge, condition);
        step = new Node(tree.getChild(2)); // step
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visited)
        {
            visited = true;
            Edge edge = new Edge(condition, null, new ConditionalEdgeData(true));
            condition.appendOutput(edge);
            return request(tree.getChild(3), new CFGPayload(edge, payload.getInterpreterManager()));
        }

        Edge edge = new Edge(condition, null, new ConditionalEdgeData(false));
        condition.appendOutput(edge);
        setResult(new CFGResult(edge));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        List<Edge> outputs = result.getValue();
        link(outputs, step);
        Edge edge = new Edge(step, null, null);
        step.appendOutput(edge);
        link(edge, condition);
    }
}
