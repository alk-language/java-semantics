package ro.uaic.info.alk.control;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.dataflow.CFGNode;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.ArrayList;
import java.util.List;

public class Node
   implements CFGNode
{
    private final List<Edge> inputs = new ArrayList<>();
    private final List<Edge> outputs = new ArrayList<>();
    private final AST tree;
    private String forcedText;
    private boolean loop = false;

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

    public void appendOutput(Edge y)
    {
        this.outputs.add(y);
    }

    public void appendInput(Edge x)
    {
        this.inputs.add(x);
    }

    public List<Edge> getPlainOutputs()
    {
        return outputs;
    }

    public List<CFGEdge> getOutputs()
    {
        return new ArrayList<>(outputs);
    }

    public List<CFGEdge> getInputs()
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

        return tree.toString().replace("\n", "");
    }

    public void forceText(String text)
    {
        forcedText = text;
    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }

    @Override
    public boolean isLoop()
    {
        return loop;
    }
}
