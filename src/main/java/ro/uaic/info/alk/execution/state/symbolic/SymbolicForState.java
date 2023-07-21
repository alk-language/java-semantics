package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.execution.state.ExecutionCloneContext;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.ForState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class SymbolicForState
   extends ForState
{
    public SymbolicForState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected boolean processValidity(Storable conditionValue)
    {
        conditionValue = conditionValue.toRValue();
        if (!(conditionValue instanceof SymbolicValue))
        {
            return super.processValidity(conditionValue);
        }
        broke = true;

        AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) conditionValue).toAST());
        Location loc = getStore().generate(new SymbolicValue(ast));
        ExecutionCloneContext cloneCtx = getExec().clone();
        AlkExecution outExec = cloneCtx.exec;
        outExec.getPathCondition().add((SymbolicValue) cloneCtx.locMapping.get(loc).getValue());

        if (outExec.getPathCondition().isSatisfiable())
        {
            outExec.start();
        }
        broke = false;

        getExec().getPathCondition().add((SymbolicValue) conditionValue.clone(generator));
        if (!getExec().getPathCondition().isSatisfiable())
        {
            getExec().halt();
        }
        return true;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicForState copy = new SymbolicForState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
