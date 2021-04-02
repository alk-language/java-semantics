package dataflow.cpropag;

import ast.AST;
import ast.expr.AssignmentAST;
import control.extractor.VarsBulkExtractor;
import dataflow.CFGEdge;
import dataflow.CFGNode;
import dataflow.TransferFunction;
import dataflow.domain.VarValue;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import symbolic.CPValue;
import visitor.SmallStepExpressionVisitor;
import visitor.interpreter.cp.CPExpressionInterpreter;

import java.util.Set;

public class CPropagTransferFunction
implements TransferFunction<VarValue>
{
    StoreImpl store;
    Environment env;

    public CPropagTransferFunction()
    {
        this.store = new StoreImpl();
        this.env = new EnvironmentImpl(store);
    }

    @Override
    public VarValue get(CFGEdge edge, VarValue input)
    {
        return get(edge.getInput().getTree(), input);
    }

    public VarValue get(AST tree, VarValue input)
    {
        if (!(tree instanceof AssignmentAST)) // id = expr;
            return input;

        AssignmentAST assgn = (AssignmentAST) tree;
        VarValue ans = VarValue.getAllUnderdefined().join(input);
        String id = getId(assgn.getChild(0)); // factor
        CPValue value = getExpr(assgn.getChild(1)); // expresison
        ans.put(id, value);
        env.update(id, ans.getValue(id));
        return ans;
    }

    private String getId(AST tree)
    {
        VarsBulkExtractor extractor = new VarsBulkExtractor();
        Set<String> vars = extractor.extract(tree);
        return vars.iterator().next();
    }

    private CPValue getExpr(AST tree)
    {
        SmallStepExpressionVisitor<CPValue> visitor = new SmallStepExpressionVisitor<>(new CPExpressionInterpreter(env, store));
        return tree.accept(visitor);
    }
}
