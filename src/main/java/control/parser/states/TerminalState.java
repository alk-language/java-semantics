package control.parser.states;

import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collections;

public class TerminalState extends CFGState
{
    public TerminalState(ParseTree tree, CFGPayload payload)
    {
        super(tree, payload);
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        ControlFlowGraph.Node node = new ControlFlowGraph.Node(tree);
        link(payload.getInputs(), Collections.singletonList(node));
        setResult(new CFGResult(node));
        return null;
    }

    @Override
    public void assign(CFGResult executionResult)
    {
        // no-op
    }
}
