package control;

import ast.AST;
import dataflow.CFG;
import dataflow.CFGEdge;
import dataflow.CFGNode;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Pair;
import util.exception.InternalException;

import java.util.*;

public abstract class ControlFlowGraph
implements CSGraph, CFG
{
    protected Node input = Node.getInput();
    protected Node output = Node.getOutput();

    @Override
    public Node getInput()
    {
        return input;
    }

    @Override
    public CFGNode getOutput()
    {
        return output;
    }

    @Override
    public abstract String graphData();



    @Override
    public List<CFGNode> getNodes()
    {
        List<CFGNode> nodes = new ArrayList<>();
        Deque<CFGNode> queue = new ArrayDeque<>();
        Set<CFGNode> visited = new HashSet<>();

        queue.addLast(getInput());
        visited.add(getInput());
        while (!queue.isEmpty())
        {
            CFGNode first = queue.pollFirst();
            nodes.add(first);
            for (CFGEdge outEdge : first.getOutputs())
            {
                CFGNode output = outEdge.getOutput();
                if (visited.contains(output))
                    continue;

                queue.addLast(output);
                visited.add(output);
            }
        }

        return nodes;
    }

    @Override
    public List<CFGEdge> getEdges()
    {
        List<CFGEdge> edges = new ArrayList<>();
        Deque<CFGNode> queue = new ArrayDeque<>();
        Set<CFGNode> visited = new HashSet<>();

        queue.addLast(getInput());
        visited.add(getInput());
        while (!queue.isEmpty())
        {
            CFGNode first = queue.pollFirst();
            for (CFGEdge outEdge : first.getOutputs())
            {
                CFGNode output = outEdge.getOutput();
                edges.add(outEdge);

                if (visited.contains(output) || output == null)
                    continue;

                queue.addLast(output);
                visited.add(output);
            }
        }

        return edges;
    }
}
