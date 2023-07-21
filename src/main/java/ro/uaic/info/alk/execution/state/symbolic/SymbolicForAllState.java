package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.expr.SymIDAST;
import ro.uaic.info.alk.ast.expr.ForAllExprAST;
import ro.uaic.info.alk.ast.symbolic.IdDeclAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.EnvironmentProxy;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicForAllState
   extends ExecutionState
{
    private Storable expr;
    private List<String> quantify = new ArrayList<>();
    private int step = 1;
    private EnvironmentProxy proxy;

    public SymbolicForAllState(AST tree, ExecutionPayload payload)
    {
        super(tree, payload);
        proxy = new EnvironmentProxy(getEnv());
        getExec().registerEnv(proxy);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (expr == null)
        {
            for (int i  = 1; i < tree.getChildCount(); i++)
            {
                String id = tree.getChild(i).getAttribute(IdASTAttr.class).getId();
                SymIDAST ast = SymIDAST.generate(id);
                SymbolicValue symVal = new SymbolicValue(ast);
                getExec().getPathCondition().setType(ast.getId(), (DataTypeAST) tree.getChild(i).getChild(0), true, true);
                proxy.addTempEntry(id, symVal);
                quantify.add("$" + ast.getId());
            }
            return request(tree.getChild(0), proxy);
        }

        ForAllExprAST ast = new ForAllExprAST(null);
        ast.addChild(SymbolicValue.toSymbolic(expr).toAST());
        for (int i = 0; i < quantify.size(); i++)
        {
            String id = quantify.get(i);
            IdDeclAST declAST = new IdDeclAST(null);
            declAST.addAttribute(IdASTAttr.class, new IdASTAttr(id));
            declAST.addChild(tree.getChild(i + 1).getChild(0));
            ast.addChild(declAST);
        }
        setResult(new ExecutionResult(new SymbolicValue(ast)));
        getExec().deregisterEnv(proxy);
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        this.expr = result.getValue().toRValue();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicForAllState copy = new SymbolicForAllState(tree, payload.clone(sm));
        copy.expr = expr == null ? null : this.expr.weakClone(sm.getLocationMapper());
        copy.quantify = expr == null ? null : new ArrayList<>(quantify);
        copy.step = this.step;
        copy.proxy = (EnvironmentProxy) sm.getEnvironmentMapper().get(proxy);
        return super.decorate(copy, sm);
    }
}
