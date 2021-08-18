package execution.state.symbolic;

import ast.AST;
import ast.OperatorUtils;
import ast.enums.Operator;
import ast.symbolic.PointerAST;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.expression.BaseBinaryOperatorState;
import execution.types.ConcreteValue;
import execution.types.alkArray.AlkArray;
import symbolic.SymbolicExecutionPayload;
import symbolic.SymbolicValue;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicBinaryState
extends BaseBinaryOperatorState
{
    public SymbolicBinaryState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Operator op, Storable current, Storable next)
    {
        Storable crv = current.toRValue();
        Storable nrv = next.toRValue();
        if ((crv instanceof ConcreteValue || crv == null) && nrv instanceof ConcreteValue)
            return super.interpretResult(op, current, next);

        if (op.equals(Operator.BRACKET))
        {
            if (crv == null)
            {
                current.toLValue().setValue(SymbolicValue.toSymbolic(new AlkArray()));
                crv = current.toRValue();
            }

            if (nrv instanceof SymbolicValue || crv instanceof SymbolicValue)
            {
                if (payload instanceof SymbolicExecutionPayload && ((SymbolicExecutionPayload) payload).isToLValue())
                {
                    StoreAST storeAST = new StoreAST(null);
                    storeAST.addChild(SymbolicValue.toSymbolic(crv).toAST());
                    storeAST.addChild(SymbolicValue.toSymbolic(nrv).toAST());
                    Location loc = getStore().malloc();
                    PointerAST point = new PointerAST(null, loc);
                    storeAST.addChild(point);
                    current.toLValue().setValue(new SymbolicValue(storeAST));
                    return loc;
                }
                else
                {
                    SelectAST selectAST = new SelectAST(null);
                    selectAST.addChild(SymbolicValue.toSymbolic(crv).toAST());
                    selectAST.addChild(SymbolicValue.toSymbolic(nrv).toAST());
                    return new SymbolicValue(selectAST);
                }
            }
        }

        if (crv == null || nrv == null)
        {
            super.handle(new AlkException("One of operands can't be evaluated!"));
        }

        SymbolicValue left = SymbolicValue.toSymbolic(crv);
        SymbolicValue right = SymbolicValue.toSymbolic(nrv);
        List<AST> children = new ArrayList<>();
        children.add(left.toAST());
        children.add(right.toAST());
        AST opTree = OperatorUtils.getOperatorAST(op, children); // TODO: DIVIDE & MOD add to path condition a / b, b != 0
        return new SymbolicValue(opTree);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicBinaryState copy = new SymbolicBinaryState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
