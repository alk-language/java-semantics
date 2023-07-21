package ro.uaic.info.alk.dataflow.cpropag;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.dataflow.TransferFunction;
import ro.uaic.info.alk.dataflow.domain.VarValue;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.EnvironmentImpl;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.symbolic.CPValue;
import ro.uaic.info.alk.visitor.SmallStepExpressionVisitor;
import ro.uaic.info.alk.visitor.interpreter.CPExpressionInterpreter;

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
