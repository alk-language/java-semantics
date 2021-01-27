package control.parser.states;

import ast.AST;
import ast.CtxState;
import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import grammar.alkParser;

import java.util.Collections;
import java.util.List;

@CtxState(ctxClass = alkParser.DoWhileStructureContext.class)
public class DoWhileState
extends CFGState
{
    ControlFlowGraph.Node node;
    int visited = 0;
    List<ControlFlowGraph.Node> terminals;

    public DoWhileState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.getChild(0)); // expression
        node.forceText("do-while (" + node.toString() + ")");
        //link(payload.getInputs(), Collections.singletonList(node));
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (visited == 0)
        {
            visited = 1;
            return request(tree.getChild(0), payload); // statement
        }

        if (visited == 1)
        {
            visited = 2;
            return request(tree.getChild(1), new CFGPayload(node));
        }

        setResult(new CFGResult(node));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        terminals = result.getValue();
        link(terminals, Collections.singletonList(node));
    }
}
