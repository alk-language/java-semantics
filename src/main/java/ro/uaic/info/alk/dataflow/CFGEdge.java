package ro.uaic.info.alk.dataflow;

import ro.uaic.info.alk.control.EdgeData;

public interface CFGEdge
{
     CFGNode getInput();
     CFGNode getOutput();
     EdgeData getEdgeData();
}
