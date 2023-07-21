package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.OperatorUtils;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.symbolic.PointerAST;
import ro.uaic.info.alk.ast.symbolic.SelectAST;
import ro.uaic.info.alk.ast.symbolic.StoreAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.BaseBinaryOperatorState;
import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicBinaryState
extends BaseBinaryOperatorState
{
    public SymbolicBinaryState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    private Storable solveBracket(Storable crv, Storable nrv, Storable current)
    {
        StoreAST storeAST = new StoreAST(null);
        SymbolicValue oldValue = SymbolicValue.toSymbolic(crv);
        storeAST.addChild(oldValue.toAST());
        SymbolicValue position = SymbolicValue.toSymbolic(nrv);
        storeAST.addChild(position.toAST());

        Location loc = getStore().malloc();
        PointerAST point = new PointerAST(null, loc);
        storeAST.addChild(point);

        SymbolicValue newValue = new SymbolicValue(storeAST);
        getExec().getPathCondition().pclh.notifyStore(oldValue, newValue, position, new SymbolicValue(point));
        current.toLValue().setValue(newValue);

        SelectAST selectAST = new SelectAST(null);
        SymbolicValue root = SymbolicValue.toSymbolic(crv);
        selectAST.addChild(root.toAST());
        SymbolicValue pos = SymbolicValue.toSymbolic(nrv);
        selectAST.addChild(pos.toAST());
        loc.setValue(new SymbolicValue(selectAST));

        return loc;
    }

    @Override
    protected Storable interpretResult(Operator op, Storable current, Storable next)
    {
        Storable crv = current.toRValue();
        Storable nrv = next.toRValue();
        if (((crv instanceof ConcreteValue && ((ConcreteValue) crv).isFullConcrete()) || crv == null) &&
             (nrv instanceof ConcreteValue && ((ConcreteValue) nrv).isFullConcrete()))
        {
            return super.interpretResult(op, current, next);
        }

        if (op.equals(Operator.BRACKET))
        {
            if (crv == null)
            {
                current.toLValue().setValue(SymbolicValue.toSymbolic(new AlkArray()));
                crv = current.toRValue();
            }

            if (nrv instanceof SymbolicValue || crv instanceof SymbolicValue)
            {
                return solveBracket(crv, nrv, current);
            }

            // crv |-> [$a], nrv |-> 1 ==>
            return super.interpretResult(op, current, next);
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
