package ro.uaic.info.alk.execution.state.function;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.enums.ParamType;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.AlkFunction;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.functions.Parameter;

import java.util.ArrayList;
import java.util.List;

public class FunctionDeclState
extends ExecutionState
{

    public FunctionDeclState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        String id = tree.getAttribute(IdASTAttr.class).getId();
        ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
        List<Parameter> params = new ArrayList<>();
        List<String> modifies = new ArrayList<>();

        for (int i = 0; i < attr.getParamCount(); i++)
        {
            Parameter param = attr.getParameter(i);
            if (param.getType() == ParamType.MODIFIES)
                modifies.add(param.getName());
            else
                params.add(param);
        }
        getFuncManager().define(new AlkFunction(id, params, modifies,
                ((FunctionDeclAST) tree).getBody(),
                ((FunctionDeclAST) tree).getRequires(),
                ((FunctionDeclAST) tree).getEnsures(),
                ((FunctionDeclAST) tree).getDataType()));
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        //
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FunctionDeclState copy = new FunctionDeclState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}