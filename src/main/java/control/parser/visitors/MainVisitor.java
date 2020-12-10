package control.parser.visitors;

import ast.StateFactory;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGProxyState;
import control.parser.CFGState;
import control.parser.states.MainState;
import grammar.alkBaseVisitor;
import grammar.alkParser;

import java.util.ArrayList;
import java.util.List;

public class MainVisitor extends alkBaseVisitor<CFGState>
{
    CFGPayload payload;
    List<ControlFlowGraph.Node> terminals = new ArrayList<>();

    public MainVisitor(CFGPayload payload)
    {
        this.payload = payload;
    }

    @Override
    public CFGState visitStartPoint(alkParser.StartPointContext ctx)
    {
        return new MainState(ctx, payload, terminals);
    }

    public List<ControlFlowGraph.Node> getTerminals()
    {
        return terminals;
    }
}
