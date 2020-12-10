package dataflow.lvars;

import control.CFGNodeImpl;
import control.ControlFlowGraph;
import dataflow.CFG;
import dataflow.CFGNode;
import util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReversedCFG implements CFG
{

    Map<CFGNode, CFGNodeImpl> mapping = new HashMap<>();
    List<CFGNode> nodes = new ArrayList<>();
    List<Pair<CFGNode, CFGNode>> edges = new ArrayList<>();

    CFGNode input;
    CFGNode output;


    public ReversedCFG(ControlFlowGraph cfg)
    {
        for (CFGNode node : cfg.getNodes())
        {
            CFGNodeImpl newNode = new CFGNodeImpl(node.getTree());
            mapping.put(node, newNode);
            nodes.add(newNode);
        }

        for (Pair<CFGNode, CFGNode> edge : cfg.getEdges())
        {
            CFGNode a = edge.x;
            CFGNode b = edge.y;

            CFGNodeImpl na = mapping.get(a);
            CFGNodeImpl nb = mapping.get(b);

            na.appendInput(nb);
            nb.appendOutput(na);
            edges.add(new Pair<>(nb, na));
        }

        this.input = mapping.get(cfg.getOutput());
        this.input.forceText("input");
        this.output = mapping.get(cfg.getInput());
        this.output.forceText("output");
    }

    @Override
    public CFGNode getInput() {
        return this.output;
    }

    @Override
    public CFGNode getOutput() {
        return this.input;
    }

    @Override
    public List<CFGNode> getNodes() {
        return nodes;
    }

    @Override
    public List<Pair<CFGNode, CFGNode>> getEdges() {
        return edges;
    }
}
