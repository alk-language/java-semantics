package dataflow;

import util.Pair;

import java.util.List;

public interface CFG
{
    CFGNode getInput();
    CFGNode getOutput();

    List< CFGNode > getNodes();
    List<Pair<CFGNode, CFGNode>> getEdges();
}
