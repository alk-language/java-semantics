package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.AssertState;
import execution.types.alkBool.AlkBool;
import smt.SMTHelper;
import symbolic.ExclusiveSymbolicValue;
import symbolic.SymbolicValue;
import util.PathCondition;
import util.types.Storable;

public class SymbolicAssertState
extends AssertState
{
    public SymbolicAssertState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();
        if (value instanceof ExclusiveSymbolicValue)
        {
            SymbolicValue symVal = SymbolicValue.toSymbolic(value);
            AST ast = UnaryAST.createUnary(Operator.NOT, symVal.toAST());

            PathCondition pc = getExec().getPathCondition().makeClone();
            pc.add(new SymbolicValue(ast));

            if (SMTHelper.validatePathCondition(getExec().getConfig(), pc))
            {
                // this should be UNSAT such that pc -> condition
                throw new AlkException("This symbolic path doesn't imply assertion!");
            }

            return new AlkBool(true);
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssertState copy = new SymbolicAssertState(tree, payload);
        return super.decorate(copy, sm);
    }
}
