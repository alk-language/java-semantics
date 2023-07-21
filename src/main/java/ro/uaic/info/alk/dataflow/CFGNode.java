package ro.uaic.info.alk.dataflow;

import ro.uaic.info.alk.ast.AST;

import java.util.List;

public interface CFGNode
{
    List<CFGEdge> getInputs();
    List<CFGEdge> getOutputs();
    AST getTree();
    void forceText(String text);
    boolean isLoop();
}
