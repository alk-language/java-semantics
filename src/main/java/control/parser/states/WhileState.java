package control.parser.states;

import ast.CtxState;
import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import control.parser.visitors.StmtVisitor;
import grammar.alkParser;

import java.util.Collections;
import java.util.List;

@CtxState(ctxClass = alkParser.WhileStructureContext.class)
public class WhileState extends CFGState
{
    alkParser.WhileStructureContext ctx;
    ControlFlowGraph.Node node;
    boolean visited = false;

    public WhileState(alkParser.WhileStructureContext tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.expression());
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
            return request(StmtVisitor.class, ctx.statement(), new CFGPayload(node));
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
