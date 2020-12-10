package control.parser.states;

import ast.CtxState;
import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import control.parser.visitors.StmtVisitor;
import grammar.alkParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CtxState(ctxClass = alkParser.IfStructureContext.class)
public class IfStmtState extends CFGState
{

    ControlFlowGraph.Node node;
    alkParser.IfStructureContext ctx;
    boolean visitedLeft = false, visitedRight = false;
    List<ControlFlowGraph.Node> outputs = new ArrayList<>();

    public IfStmtState(alkParser.IfStructureContext tree, CFGPayload payload)
    {
        super(tree, payload);
        node = new ControlFlowGraph.Node(tree.expression());
        node.forceText("if (" + node.toString() + ")");
        link(payload.getInputs(), Collections.singletonList(node));
        this.ctx = tree;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (!visitedLeft)
        {
            visitedLeft = true;
            return request(StmtVisitor.class, ctx.statement(0), new CFGPayload(node));
        }
        if (ctx.statement().size() > 1 && !visitedRight)
        {
            visitedRight = true;
            return request(StmtVisitor.class, ctx.statement(1), new CFGPayload(node));
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
