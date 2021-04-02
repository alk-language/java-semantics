package dataflow.lvars;

import control.ControlFlowGraph;
import control.Edge;
import control.Node;
import dataflow.CFG;
import dataflow.CFGEdge;
import dataflow.CFGNode;
import util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReversedCFG
implements CFG
{

    Map<CFGNode, Node> mapping = new HashMap<>();
    List<CFGNode> nodes = new ArrayList<>();
    List<CFGEdge> edges = new ArrayList<>();

    CFGNode input;
    CFGNode output;


    public ReversedCFG(ControlFlowGraph cfg)
    {
        for (CFGNode node : cfg.getNodes())
        {
            Node newNode = new Node(node.getTree());
            mapping.put(node, newNode);
            nodes.add(newNode);
        }

        for (CFGEdge edge : cfg.getEdges())
        {
            CFGNode a = edge.getInput();
            CFGNode b = edge.getOutput();

            Node na = mapping.get(a);
            Node nb = mapping.get(b);

            Edge newEdge = new Edge(nb, na, edge.getEdgeData());
            nb.appendOutput(newEdge);
            na.appendInput(newEdge);
            edges.add(newEdge);
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
    public List<CFGEdge> getEdges() {
        return edges;
    }
}
