package dataflow.wcet;

import ast.AST;
import ast.expr.ExpressionAST;
import ast.stmt.ExprStmtAST;
import dataflow.CFGNode;
import dataflow.TransferFunction;
import dataflow.domain.ProgramContext;
import execution.parser.exceptions.NotImplementedException;

public class SeqWCETTransferFunction
implements TransferFunction<ProgramContext>
{
    @Override
    public ProgramContext get(CFGNode node, ProgramContext input)
    {
        return get(node.getTree(), input);
    }

    public ProgramContext get(AST tree, ProgramContext input)
    {
        if (tree == null)
            return input;

        if (tree instanceof ExpressionAST)
        {
            input.notifyExpr(tree);
        }
        else if (tree instanceof ExprStmtAST)
        {
            input.notifyExpr(tree.getChild(0));
        }
        else
        {
            throw new NotImplementedException("Sequential WCET is not working for this kind of AST: " + tree.toString());
        }

        return input;
    }
}
