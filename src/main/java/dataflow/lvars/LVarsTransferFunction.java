package dataflow.lvars;

import control.extractor.VarsBulkExtractor;
import dataflow.CFGNode;
import dataflow.TransferFunction;
import dataflow.domain.VariableSet;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class LVarsTransferFunction implements TransferFunction<VariableSet>
{
    @Override
    public VariableSet get(CFGNode node, VariableSet input)
    {
        return get(node.getTree(), input);
    }

    private VariableSet get(ParseTree tree, VariableSet set)
    {
        return set.remove(kill(tree)).union(gen(tree));
    }

    private VariableSet gen(ParseTree tree)
    {
        if (!(tree instanceof alkParser.AssignmentStmtContext))
            return VariableSet.getEmptySet();

        alkParser.AssignmentStmtContext assgnTree = (alkParser.AssignmentStmtContext) tree;
        return new VariableSet(new VarsBulkExtractor().extract(assgnTree.expression()));
    }

    private VariableSet kill(ParseTree tree)
    {
        if (!(tree instanceof alkParser.AssignmentStmtContext))
            return VariableSet.getEmptySet();

        alkParser.AssignmentStmtContext assgnTree = (alkParser.AssignmentStmtContext) tree;
        return new VariableSet(new VarsBulkExtractor().extract(assgnTree.factor()));
    }
}
