package control.parser.states;

import ast.AST;
import ast.CtxState;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import grammar.alkParser;

import java.util.Collections;
import java.util.List;

@CtxState(ctxClass = alkParser.WhileStructureContext.class)
public class WhileState extends CFGState
{
    AST ctx;
    ControlFlowGraph.Node node;
    boolean visited = false;

    public WhileState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.getChild(0)); // expression
        node.forceText("while (" + node.toString() + ")");
        link(payload.getInputs(), Collections.singletonList(node));
        this.ctx = tree;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visited)
        {
            visited = true;
            return request(ctx.getChild(0), new CFGPayload(node)); // statement
        }

        setResult(new CFGResult(node));
        return null;
    }

    @Override
    public void assign(CFGResult result)
    {
        List<ControlFlowGraph.Node> outputs = result.getValue();
        link(outputs, Collections.singletonList(node));
    }
}
