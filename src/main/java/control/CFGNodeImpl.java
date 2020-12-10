package control;

import dataflow.CFGNode;
import org.antlr.v4.runtime.tree.ParseTree;
import util.exception.InternalException;

import java.util.ArrayList;
import java.util.List;

public class CFGNodeImpl implements CFGNode
{
    private List<CFGNode> inputs = new ArrayList<>();
    private List<CFGNode> outputs = new ArrayList<>();
    private ParseTree tree;
    private String forcedText;

    public CFGNodeImpl(ParseTree tree)
    {
        this.tree = tree;
    }


    public void appendOutput(CFGNode y)
    {
        this.outputs.add(y);
    }

    public void appendInput(CFGNode x)
    {
        this.inputs.add(x);
    }

    @Override
    public List<CFGNode> getInputs() {
        return inputs;
    }

    @Override
    public List<CFGNode> getOutputs() {
        return outputs;
    }

    @Override
    public ParseTree getTree() {
        return tree;
    }

    public void forceText(String text)
    {
        forcedText = text;
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
}
