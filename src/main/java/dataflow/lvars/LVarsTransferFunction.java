package dataflow.lvars;

import ast.AST;
import ast.expr.AssignmentAST;
import ast.expr.ExpressionAST;
import ast.stmt.ExprStmtAST;
import control.extractor.VarsBulkExtractor;
import dataflow.CFGNode;
import dataflow.TransferFunction;
import dataflow.domain.VariableSet;

public class LVarsTransferFunction
implements TransferFunction<VariableSet>
{
    @Override
    public VariableSet get(CFGNode node, VariableSet input)
    {
        return get(node.getTree(), input);
    }

    private VariableSet get(AST tree, VariableSet set)
    {
        return set.remove(kill(tree)).union(gen(tree));
    }

    private VariableSet gen(AST tree)
    {
        if (!(tree instanceof ExprStmtAST && tree.getChild(0) instanceof AssignmentAST))
        {
            return VariableSet.getEmptySet();
        }

        AssignmentAST assgnTree = (AssignmentAST) tree.getChild(0);
        return new VariableSet(new VarsBulkExtractor().extract(assgnTree.getChild(1)));
    }

    private VariableSet kill(AST tree)
    {
        if (!(tree instanceof ExprStmtAST))
        {
            return VariableSet.getEmptySet();
        }

        AssignmentAST assgnTree = (AssignmentAST) tree.getChild(0);
        return new VariableSet(new VarsBulkExtractor().extract(assgnTree.getChild(0)));
    }
}
