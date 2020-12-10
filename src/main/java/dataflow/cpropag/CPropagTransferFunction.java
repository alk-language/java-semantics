package dataflow.cpropag;

import control.extractor.VarsBulkExtractor;
import dataflow.CFGNode;
import dataflow.TransferFunction;
import dataflow.domain.VarValue;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import symbolic.SymbolicValue;
import visitor.ExpressionVisitor;
import visitor.SymbolicExpressionInterpreter;

import java.util.Set;

public class CPropagTransferFunction implements TransferFunction<VarValue>
{
    StoreImpl store;
    Environment env;

    public CPropagTransferFunction()
    {
        this.store = new StoreImpl();
        this.env = new EnvironmentImpl(store);
    }

    @Override
    public VarValue get(CFGNode node, VarValue input)
    {
        return get(node.getTree(), input);
    }

    public VarValue get(ParseTree tree, VarValue input)
    {
        if (!(tree instanceof alkParser.AssignmentStmtContext)) // id = expr;
            return input;

        alkParser.AssignmentStmtContext assgn = (alkParser.AssignmentStmtContext) tree;
        VarValue ans = VarValue.getAllUnderdefined().join(input);
        String id = getId(assgn.factor());
        SymbolicValue value = getExpr(assgn.expression());
        ans.put(id, value);
        env.update(id, ans.getValue(id));
        return ans;
    }

    private String getId(alkParser.FactorContext factorCtx)
    {
        VarsBulkExtractor extractor = new VarsBulkExtractor();
        Set<String> vars = extractor.extract(factorCtx);
        return vars.iterator().next();
    }

    private SymbolicValue getExpr(alkParser.ExpressionContext exprCtx)
    {
        ExpressionVisitor<SymbolicValue> visitor = new ExpressionVisitor<>(new SymbolicExpressionInterpreter(env, store));
        return visitor.visit(exprCtx);
    }
}
