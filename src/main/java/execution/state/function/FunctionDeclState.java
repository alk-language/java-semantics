package execution.state.function;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.stmt.FunctionDeclAST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.parser.env.AlkFunction;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.Pair;
import util.functions.Parameter;

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
            if (param.getType() == ParamType.GLOBAL)
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