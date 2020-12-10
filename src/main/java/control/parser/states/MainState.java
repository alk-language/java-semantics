package control.parser.states;

import ast.CtxState;
import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import control.parser.visitors.StmtVisitor;
import grammar.alkParser;

import java.util.List;

@CtxState(ctxClass = alkParser.StartPointContext.class)
public class MainState extends CFGState {

    alkParser.StartPointContext ctx;
    boolean visited = false;
    List<ControlFlowGraph.Node> terminals;

    public MainState(alkParser.StartPointContext tree, CFGPayload payload, List<ControlFlowGraph.Node> terminals) {
        super(tree, payload);
        this.ctx = tree;
        this.terminals = terminals;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (visited)
        {
            return null;
        }

        visited = true;
        return request(StmtVisitor.class, ctx.statement_sequence(), payload);
    }

    @Override
    public void assign(CFGResult result)
    {
        terminals.addAll(result.getValue());
    }
}
