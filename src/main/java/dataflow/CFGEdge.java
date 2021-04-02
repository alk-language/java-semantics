package dataflow;

import control.EdgeData;

public interface CFGEdge
{
     CFGNode getInput();
     CFGNode getOutput();
     EdgeData getEdgeData();
}
