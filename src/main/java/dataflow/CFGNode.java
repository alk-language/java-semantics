package dataflow;

import ast.AST;

import java.util.List;

public interface CFGNode
{
    List<CFGNode> getInputs();
    List<CFGNode> getOutputs();
    AST getTree();
    void forceText(String text);
}
