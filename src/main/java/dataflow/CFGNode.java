package dataflow;

import ast.AST;
import control.ControlFlowGraph;

import java.util.List;

public interface CFGNode
{
    List<CFGEdge> getInputs();
    List<CFGEdge> getOutputs();
    AST getTree();
    void forceText(String text);
}
