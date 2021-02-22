package control.parser.states;

import ast.AST;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IfStmtState
extends CFGState
{
    ControlFlowGraph.Node node;
    boolean visitedLeft = false, visitedRight = false;
    List<ControlFlowGraph.Node> outputs = new ArrayList<>();

    public IfStmtState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.getChild(0)); // expression
        node.forceText("if (" + node.toString() + ")");
        link(payload.getInputs(), Collections.singletonList(node));
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visitedLeft)
        {
            visitedLeft = true;
            return request(tree.getChild(1), new CFGPayload(node, payload.getInterpreterManager()));
        }
        if (tree.getChildCount() > 2 && !visitedRight) // statement
        {
            visitedRight = true;
            return request(tree.getChild(2), new CFGPayload(node, payload.getInterpreterManager()));
        }
        if (!visitedRight)
        {
            outputs.add(node);
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
