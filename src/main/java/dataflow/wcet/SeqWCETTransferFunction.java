package dataflow.wcet;

import ast.AST;
import ast.expr.ExpressionAST;
import ast.stmt.ExprStmtAST;
import control.EdgeData;
import dataflow.CFGEdge;
import dataflow.TransferFunction;
import dataflow.domain.ProgramContext;
import execution.parser.exceptions.NotImplementedException;

public class SeqWCETTransferFunction
implements TransferFunction<ProgramContext>
{
    @Override
    public ProgramContext get(CFGEdge edge, ProgramContext input)
    {
        return get(edge.getInput().getTree(), edge.getEdgeData(), input);
    }

    public ProgramContext get(AST tree, EdgeData data, ProgramContext input)
    {
        ProgramContext pc = new ProgramContext(input);
        if (tree == null)
        {
            return pc;
        }

        pc.run(tree, data);


        return pc;
    }
}
