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

@CtxState(ctxClass = alkParser.DoWhileStructureContext.class)
public class DoWhileState extends CFGState
{
    alkParser.DoWhileStructureContext ctx;
    ControlFlowGraph.Node node;
    int visited = 0;
    List<ControlFlowGraph.Node> terminals;

    public DoWhileState(alkParser.DoWhileStructureContext tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.expression());
        node.forceText("do-while (" + node.toString() + ")");
        //link(payload.getInputs(), Collections.singletonList(node));
        this.ctx = tree;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (visited == 0)
        {
            visited = 1;
            return request(StmtVisitor.class, ctx.statement(), payload);
        }

        if (visited == 1)
        {
            visited = 2;
            return request(StmtVisitor.class, ctx.statement(), new CFGPayload(node));
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
