package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.RepresentationASTAttr;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.IterableWithIntervalState;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.ast.expr.RelationalAST;
import ro.uaic.info.alk.ast.expr.SetAST;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SetSymbolicIntervalState
   extends IterableWithIntervalState
{
    public SetSymbolicIntervalState(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        super(primitive, ast, payload);
    }

    @Override
    public Storable getFinalResult()
    {
        Storable x = limits.get(0);
        Storable y = limits.get(1);

        if (x instanceof AlkInt && y instanceof AlkInt)
        {
            return super.getFinalResult();
        }

        SymbolicValue left = SymbolicValue.toSymbolic(x);
        SymbolicValue right = SymbolicValue.toSymbolic(y);

        List<AST> children = new ArrayList<>();
        children.add(left.toAST());
        children.add(right.toAST());
        AST check = RelationalAST.createBinary(Operator.LOWER_EQ, children);
        if (!getExec().getPathCondition().asserts(new SymbolicValue(check)))
        {
            super.handle(new AlkException(AlkException.ERR_LIMIT));
        }

        AST target = new SetAST(null);
        RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.INTERVAL);
        target.addAttribute(RepresentationASTAttr.class, attr);

        target.addChild(left.toAST());
        target.addChild(right.toAST());

        return new SymbolicValue(target);

        /*
        // TODO: check both are ints

        // generate symbolic value
        AST symAST = SymIDAST.generate("[ival]");
        SymbolicValue value = new SymbolicValue(symAST);
        DataTypeAST dataType = new SetDataTypeAST(null);
        dataType.addChild(new IntDataTypeAST(null));
        getExec().getPathCondition().setType(symAST.getText(), dataType, true);

        // check size is preserved: $ap_0.size() == y - x + 1
        children.clear();
        children.add(right.toAST());
        children.add(left.toAST());
        AST diff = AdditiveAST.createBinary(Operator.SUBTRACT, children);

        children.clear();
        children.add(diff);
        children.add(new IntAST("1"));
        AST newSize = AdditiveAST.createBinary(Operator.ADD, children);

        FactorPointMethodAST oldSize = new FactorPointMethodAST(null);
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethodHelper.parse("size"));
        oldSize.addAttribute(BuiltInMethodASTAttr.class, attr);
        oldSize.addChild(value.toAST());

        children.clear();
        children.add(oldSize);
        children.add(newSize);

        AST checkSize = EqualityAST.createBinary(Operator.EQUAL, children);
        getExec().getPathCondition().add(new SymbolicValue(checkSize));

        // do the value mapping: forall i : int :: l <= i && i <= r ==> $ap_0[i]
        AST bound = SymIDAST.generate("[iter]");

        children.clear();
        children.add(left.toAST());
        children.add(bound);
        AST lowerBound = RelationalAST.createBinary(Operator.LOWEREQ, children);

        children.clear();
        children.add(bound);
        children.add(right.toAST());
        AST upperBound = RelationalAST.createBinary(Operator.LOWEREQ, children);

        children.clear();
        children.add(lowerBound);
        children.add(upperBound);
        AST conjunction = LogicalAndAST.createBinary(Operator.LOGICALAND, children);

        children.clear();
        children.add(bound);
        children.add(symAST);
        AST body = InExprAST.createBinary(Operator.IN, children);

        AST eqAST = new EquivAST(null);
        eqAST.addChild(conjunction);
        eqAST.addChild(body);

        ForAllExprAST mapping = new ForAllExprAST(null);
        mapping.addChild(eqAST);

        IdDeclAST idDecl = new IdDeclAST(null);
        IdASTAttr boundAttr = new IdASTAttr("$" + bound.getText());
        idDecl.addAttribute(IdASTAttr.class, boundAttr);
        idDecl.addChild(new IntDataTypeAST(null));
        mapping.addChild(idDecl);

        getExec().getPathCondition().setType(bound.getText(), new IntDataTypeAST(null), true);
        getExec().getPathCondition().add(new SymbolicValue(mapping));

        return generator.generate(value);*/
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        SetSymbolicIntervalState copy = new SetSymbolicIntervalState(primitive, tree, payload.clone(sm));
        for (Storable value : limits)
        {
            copy.limits.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }
}
