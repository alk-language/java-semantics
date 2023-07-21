package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.enums.Statement;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.AssumeState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InvalidAssumptionException;
import ro.uaic.info.alk.exeptions.InvalidStatementException;
import ro.uaic.info.alk.exeptions.UnexpectedTypeException;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class SymbolicAssumeState
   extends AssumeState
{
    public SymbolicAssumeState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();
        if (value instanceof SymbolicValue)
        {
            SymbolicValue symVal = (SymbolicValue) value;
            if (!((ExpressionAST) symVal.toAST()).getDataType(getExec().getPathCondition()).equals(
               BoolDataTypeAST.INSTANCE))
            {
                throw new InvalidStatementException(Statement.ASSUME,
                                                    new UnexpectedTypeException(tree.getChild(0),
                                                                                symVal,
                                                                                AlkBool.class));
            }
            getExec().getPathCondition().add((SymbolicValue) symVal.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new InvalidAssumptionException(tree.getChild(0), symVal));
            }

            return AlkBool.TRUE;
        }

        return super.interpretResult(value);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssumeState copy = new SymbolicAssumeState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
