package ro.uaic.info.alk.dataflow.lvars;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.dataflow.CFGNode;
import ro.uaic.info.alk.dataflow.TransferFunction;
import ro.uaic.info.alk.dataflow.domain.VariableSet;

public class LVarsTransferFunction
   implements TransferFunction<VariableSet>
{
    @Override
    public VariableSet get(CFGEdge edge, VariableSet input)
    {
        CFGNode node = edge.getInput();
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
