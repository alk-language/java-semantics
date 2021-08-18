package dataflow.wcet;

import ast.AST;
import ast.VirtualAST;
import ast.expr.ExpressionAST;
import ast.stmt.ExprStmtAST;
import ast.stmt.WhileAST;
import control.EdgeData;
import dataflow.CFGEdge;
import dataflow.TransferFunction;
import dataflow.domain.ProgramContext;
import execution.parser.exceptions.NotImplementedException;
import symbolic.SymbolicValue;

public class SeqWCETTransferFunction
implements TransferFunction<ProgramContext>
{
    @Override
    public ProgramContext get(CFGEdge edge, ProgramContext input)
    {
        boolean loop = edge.getInput().isLoop();
        return get(edge.getInput().getTree(), edge.getEdgeData(), input, loop);
    }

    public ProgramContext get(AST tree, EdgeData data, ProgramContext input, boolean loop)
    {
        ProgramContext pc = new ProgramContext(input);
        if (tree == null)
        {
            return pc;
        }

        if (loop) // is loop
        {
            pc.removeAllInside(tree);
            pc.markInside(tree);
            // 1) add condition to path condition
            if (data.getCondition())
            {
                // true branch
                // 2) switch variable values to virtual value: x(t)
                pc.virtualize((String id) -> new SymbolicValue(new VirtualAST(id, tree, false)));
            }
            else
            {
                // false branch
                // 2) switch variable values to virtual value: x(omega)
                pc.virtualize((String id) -> new SymbolicValue(new VirtualAST(id, tree, true)));
            }

            pc.run(tree, data);

            return pc;
        }

        pc.run(tree, data);
        return pc;
    }
}
