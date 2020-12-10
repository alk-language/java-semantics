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

@CtxState(ctxClass = alkParser.ForStructureContext.class)
public class ForState extends CFGState
{
    ControlFlowGraph.Node initNode, condition, step;
    alkParser.ForStructureContext ctx;
    private boolean visited = false;

    public ForState(alkParser.ForStructureContext tree, CFGPayload payload)
    {
        super(tree, payload);
        initNode = new ControlFlowGraph.Node(tree.start_assignment());
        link(payload.getInputs(), Collections.singletonList(initNode));
        condition = new ControlFlowGraph.Node(tree.expression());
        link(Collections.singletonList(initNode), Collections.singletonList(condition));
        step = new ControlFlowGraph.Node(tree.increase_decrease());
        this.ctx = tree;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visited)
        {
            visited = true;
            return request(StmtVisitor.class, ctx.statement(), new CFGPayload(condition));
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
