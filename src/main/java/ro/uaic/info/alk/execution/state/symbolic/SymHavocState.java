package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.expr.SymIDAST;
import ro.uaic.info.alk.ast.stmt.DeclAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.utils.TypeHelper;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

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
