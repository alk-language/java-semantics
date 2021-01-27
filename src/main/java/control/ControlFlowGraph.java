package control;

import ast.AST;
import dataflow.CFG;
import dataflow.CFGNode;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Pair;
import util.exception.InternalException;

import java.util.*;

public abstract class ControlFlowGraph implements CSGraph, CFG
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

    public static class Node implements CFGNode
    {
        private List<Node> inputs = new ArrayList<>();
        private List<Node> outputs = new ArrayList<>();
        private AST tree;
        private String forcedText;

        static Node getInput()
        {
            Node node = new Node(null);
            node.forcedText = "input";
            return node;
        }

        public static Node getOutput()
        {
            Node node = new Node(null);
            node.forcedText = "output";
            return node;
        }

        public Node(AST tree)
        {
            this.tree = tree;
        }

        public void appendOutput(Node y)
        {
            this.outputs.add(y);
        }

        public void appendInput(Node x)
        {
            this.inputs.add(x);
        }

        public List<Node> getPlainOutputs()
        {
            return outputs;
        }

        public List<CFGNode> getOutputs()
        {
            return new ArrayList<>(outputs);
        }

        public List<CFGNode> getInputs()
        {
            return new ArrayList<>(inputs);
        }

        public AST getTree()
        {
            return tree;
        }

        @Override
        public String toString()
        {
            if (forcedText != null)
            {
                return forcedText;
            }

            if (tree == null)
            {
                throw new InternalException("Found CFG node without associated AST tree.");
            }

            return tree.getText();
        }

        public void forceText(String text)
        {
            forcedText = text;
        }
    }

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
            for (CFGNode output : first.getOutputs())
            {
                if (visited.contains(output))
                    continue;

                queue.addLast(output);
                visited.add(output);
            }
        }

        return nodes;
    }

    @Override
    public List<Pair<CFGNode, CFGNode>> getEdges()
    {
        List<Pair<CFGNode, CFGNode> > edges = new ArrayList<>();
        Deque<CFGNode> queue = new ArrayDeque<>();
        Set<CFGNode> visited = new HashSet<>();

        queue.addLast(getInput());
        visited.add(getInput());
        while (!queue.isEmpty())
        {
            CFGNode first = queue.pollFirst();
            for (CFGNode output : first.getOutputs())
            {
                edges.add(new Pair<>(first, output));

                if (visited.contains(output))
                    continue;

                queue.addLast(output);
                visited.add(output);
            }
        }

        return edges;
    }
}
