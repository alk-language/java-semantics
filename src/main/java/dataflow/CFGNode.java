package dataflow;

import control.ControlFlowGraph;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public interface CFGNode
{
    List<CFGNode> getInputs();
    List<CFGNode> getOutputs();
    ParseTree getTree();
    void forceText(String text);
}
