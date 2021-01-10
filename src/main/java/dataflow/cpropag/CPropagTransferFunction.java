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
import symbolic.CPValue;
import visitor.ExpressionVisitor;
import visitor.CPExpressionInterpreter;
import visitor.ParseTreeExprVisitor;

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
        CPValue value = getExpr(assgn.expression());
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

    private CPValue getExpr(alkParser.ExpressionContext exprCtx)
    {
        ExpressionVisitor<CPValue> visitor = new ExpressionVisitor<>(new CPExpressionInterpreter(env, store));
        return new ParseTreeExprVisitor().visit(exprCtx).accept(visitor);
    }
}
