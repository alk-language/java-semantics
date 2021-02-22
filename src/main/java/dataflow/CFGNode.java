package dataflow;

import ast.AST;
import control.ControlFlowGraph;

import java.util.List;

public interface CFGNode
{
    List<CFGNode> getInputs();
    List<CFGNode> getOutputs();
    AST getTree();
    void forceText(String text);
}
