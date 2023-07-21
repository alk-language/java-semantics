package ro.uaic.info.alk.dataflow;

import java.util.List;

public interface CFG
{
    CFGNode getInput();
    CFGNode getOutput();

    List< CFGNode > getNodes();
    List< CFGEdge > getEdges();
}
