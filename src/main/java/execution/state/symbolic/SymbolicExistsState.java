package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.expr.SymIDAST;
import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import ast.symbolic.IdDeclAST;
import ast.type.DataTypeAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.EnvironmentProxy;
import execution.state.ExecutionState;
import symbolic.SymbolicValue;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicExistsState
extends ExecutionState
{
    private Storable expr;
    private List<String> quantify = new ArrayList<>();
    private int step = 1;

    public SymbolicExistsState(AST tree, ExecutionPayload payload)
    {
        super(tree, payload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (expr == null)
        {
            EnvironmentProxy proxy = new EnvironmentProxy(getEnv());
            for (int i  = 1; i < tree.getChildCount(); i++)
            {
                String id = tree.getChild(i).getAttribute(IdASTAttr.class).getId();
                SymIDAST ast = SymIDAST.generate(id);
                SymbolicValue symVal = new SymbolicValue(ast);
                getExec().getPathCondition().setType(ast.getId(), (DataTypeAST) tree.getChild(i).getChild(0), true);
                proxy.define(id).setValue(symVal);
                quantify.add("$" + ast.getId());
            }
            return request(tree.getChild(0), proxy);
        }

        ExistsExprAST ast = new ExistsExprAST(null);
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
        SymbolicExistsState copy = new SymbolicExistsState(tree, payload.clone(sm));
        copy.expr = expr == null ? null : this.expr.weakClone(sm.getLocationMapper());
        copy.quantify = expr == null ? null : new ArrayList<>(quantify);
        copy.step = this.step;
        return super.decorate(copy, sm);
    }
}

