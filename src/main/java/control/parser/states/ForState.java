package control.parser.states;

import ast.AST;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;

import java.util.Collections;
import java.util.List;

public class ForState extends CFGState
{
    ControlFlowGraph.Node initNode, condition, step;
    private boolean visited = false;

    public ForState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        initNode = new ControlFlowGraph.Node(tree.getChild(0)); // startassignment
        link(payload.getInputs(), Collections.singletonList(initNode));
        condition = new ControlFlowGraph.Node(tree.getChild(1)); // expression
        link(Collections.singletonList(initNode), Collections.singletonList(condition));
        step = new ControlFlowGraph.Node(tree.getChild(2)); // increasedecrease
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visited)
        {
            visited = true;
            return request(tree.getChild(3), new CFGPayload(condition, payload.getInterpreterManager()));
        }

        setResult(new CFGResult(condition));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        List<ControlFlowGraph.Node> outputs = result.getValue();
        link(outputs, Collections.singletonList(step));
        link(Collections.singletonList(step), Collections.singletonList(condition));
    }
}
