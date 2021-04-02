package control.parser.states;

import ast.AST;
import control.Edge;
import control.Node;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;

import java.util.Collections;

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
