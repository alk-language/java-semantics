package ro.uaic.info.alk.control;

import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.dataflow.CFGNode;

public class Edge
implements CFGEdge
{
    private Node input;
    private Node output;
    private EdgeData data;

    public Edge(Node input, Node output, EdgeData data)
    {
        this.input = input;
        this.output = output;
        this.data = data;
    }

    public CFGNode getInput()
    {
        return this.input;
    }

    public CFGNode getOutput()
    {
        return this.output;
    }

    public EdgeData getEdgeData()
    {
        return this.data;
    }

    public void setOutput(Node output)
    {
        this.output = output;
    }
}
