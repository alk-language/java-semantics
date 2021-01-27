package control.parser;

import ast.AST;
import ast.State;
import control.ControlFlowGraph;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public abstract class CFGState extends State<CFGPayload, CFGResult>
{
    public CFGState(AST tree, CFGPayload payload)
    {
        // to be resolved
        super(tree, payload, null);
    }

    protected void link(List<ControlFlowGraph.Node> list1, List<ControlFlowGraph.Node> list2)
    {
        for (ControlFlowGraph.Node x : list1)
        {
            for (ControlFlowGraph.Node y : list2)
            {
                x.appendOutput(y);
                y.appendInput(x);
            }
        }
    }
}
