package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.expr.SymIDAST;
import ast.stmt.DeclAST;
import ast.type.DataTypeAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.utils.TypeHelper;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymHavocState
extends ExecutionState
{
    public SymHavocState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        for (AST ast : tree.getChildren())
        {
            DeclAST declAST = (DeclAST) ast;
            String id = declAST.getAttribute(IdASTAttr.class).getId();
            DataTypeAST dataType;
            Location loc;
            if (declAST.getChildCount() == 1)
            {
                loc = getEnv().define(id);
                dataType = (DataTypeAST) declAST.getChild(0);
            }
            else
            {
                if (!getEnv().has(id))
                {
                    super.handle(new AlkException("Can't find " + id + " in the current environment!"));
                }
                loc = getEnv().getLocation(id);
                Storable value = loc.toRValue();
                dataType = TypeHelper.getDataType(value, getPayload().getExecution().getPathCondition());
            }

            AST symAST = SymIDAST.generate(id);
            loc.setValue(new SymbolicValue(symAST));

            getExec().getPathCondition().setType(symAST.getText(), dataType, true);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymHavocState copy = new SymHavocState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
