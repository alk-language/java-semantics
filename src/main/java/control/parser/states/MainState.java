package control.parser.states;

import ast.AST;
import ast.CtxState;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import grammar.alkParser;

import java.util.List;

@CtxState(ctxClass = alkParser.StartPointContext.class)
public class MainState extends CFGState {

    boolean visited = false;
    List<ControlFlowGraph.Node> terminals;

    public MainState(AST tree, CFGPayload payload, List<ControlFlowGraph.Node> terminals) {
        super(tree, payload);
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
        return request(tree.getChild(0), payload);
    }

    @Override
    public void assign(CFGResult result)
    {
        terminals.addAll(result.getValue());
    }
}
