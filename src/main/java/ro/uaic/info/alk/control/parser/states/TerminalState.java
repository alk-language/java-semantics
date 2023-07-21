package ro.uaic.info.alk.control.parser.states;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.control.Node;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.control.parser.CFGPayload;
import ro.uaic.info.alk.control.parser.CFGResult;
import ro.uaic.info.alk.control.parser.CFGState;

public class TerminalState
extends CFGState
{
    public TerminalState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        Node node = new Node(tree);
        link(payload.getInputs(), node);
        Edge edge = new Edge(node, null, null);
        node.appendOutput(edge);
        setResult(new CFGResult(edge));
        return null;
    }

    @Override
    public void assign(CFGResult executionResult)
    {
        // no-op
    }
}
