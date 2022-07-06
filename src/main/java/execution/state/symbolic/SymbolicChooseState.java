package execution.state.symbolic;

import ast.AST;
import ast.attr.BuiltInMethodASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.RepresentationASTAttr;
import ast.enums.BuiltInMethod;
import ast.enums.CompoundValueRepresentation;
import ast.enums.Operator;
import ast.expr.*;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import ast.type.*;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.ChooseStmtState;
import execution.types.AlkIterableValue;
import symbolic.SymbolicValue;


import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_CHOOSE_NOT_ITERABLE;

public class SymbolicChooseState
extends ChooseStmtState
{
    private static final String chosenIdx = "\\chosenIdx";
    private static final String chosenValue = "\\chosenValue";
    private boolean isConcrete = false;
    private SymbolicValue symSource = null;

    public SymbolicChooseState(AST tree, ExecutionPayload executionPayload, boolean uniform)
    {
        super(tree, executionPayload, uniform);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (target == null)
        {
            return super.request(tree.getChild(0));
        }
        if (source == null && symSource == null)
        {
            return super.request(tree.getChild(1));
        }

        if (isConcrete)
        {
            return super.makeStep();
        }

        DataTypeAST dataTypeAST = ((ExpressionAST) symSource.toAST()).getDataType(getExec().getPathCondition());

        // if interval, make things easier
        if (symSource.toAST().hasAttribute(RepresentationASTAttr.class) &&
                symSource.toAST().getAttribute(RepresentationASTAttr.class).getRepresentation() == CompoundValueRepresentation.INTERVAL)
        {
            AST lft = symSource.toAST().getChild(0);
            AST rgh = symSource.toAST().getChild(1);

            AST symAST = SymIDAST.generate(chosenValue);
            getExec().getPathCondition().setType(symAST.getText(), new IntDataTypeAST(tree.getCtx()), true);

            List<AST> children = new ArrayList<>();
            children.add(lft);
            children.add(symAST);
            getExec().getPathCondition().add(new SymbolicValue(RelationalAST.createBinary(Operator.LOWEREQ, children)));

            children.clear();
            children.add(symAST);
            children.add(rgh);
            getExec().getPathCondition().add(new SymbolicValue(RelationalAST.createBinary(Operator.LOWEREQ, children)));

            target.setValue(new SymbolicValue(symAST));
            return null;
        }

        if (dataTypeAST instanceof ArrayDataTypeAST || dataTypeAST instanceof ListDataTypeAST)
        {
            AST symAST = SymIDAST.generate(chosenIdx);
            getExec().getPathCondition().setType(symAST.getText(), new IntDataTypeAST(tree.getCtx()), true);

            List<AST> children = new ArrayList<>();
            children.add(new IntAST("0"));
            children.add(symAST);
            getExec().getPathCondition().add(new SymbolicValue(RelationalAST.createBinary(Operator.LOWEREQ, children)));

            children.clear();
            children.add(symAST);
            FactorPointMethodAST factorPointMethodAST = new FactorPointMethodAST(tree.getCtx());
            factorPointMethodAST.addAttribute(BuiltInMethodASTAttr.class, new BuiltInMethodASTAttr(BuiltInMethod.SIZE));
            factorPointMethodAST.addChild(symSource.toAST());
            children.add(factorPointMethodAST);
            getExec().getPathCondition().add(new SymbolicValue(RelationalAST.createBinary(Operator.LOWER, children)));

            SelectAST selectAST = new SelectAST(tree.getCtx());
            selectAST.addChild(symSource.toAST());
            selectAST.addChild(symAST);
            target.setValue(new SymbolicValue(selectAST));
        }
        else if (dataTypeAST instanceof SetDataTypeAST)
        {
            AST symAST = SymIDAST.generate(chosenValue);
            getExec().getPathCondition().setType(symAST.getText(), ((SetDataTypeAST) dataTypeAST).getTypeAst(), true);

            InExprAST expr = new InExprAST(tree.getCtx());
            expr.addChild(symAST);
            expr.addChild(symSource.toAST());
            OpsASTAttr attr = new OpsASTAttr();
            attr.add(Operator.IN);
            expr.addAttribute(OpsASTAttr.class, attr);
            getExec().getPathCondition().add(new SymbolicValue(expr));

            target.setValue(new SymbolicValue(symAST));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (isConcrete)
        {
            super.assign(executionResult);
            return;
        }

        if (target == null)
        {
            target = executionResult.getValue().toLValue();
        }
        else if (source == null && symSource == null)
        {
            if (executionResult.getValue().toRValue() instanceof AlkIterableValue)
            {
                isConcrete = true;
                source = ((AlkIterableValue) executionResult.getValue().toRValue()).toArray();
            }
            else if (executionResult.getValue().toRValue() instanceof SymbolicValue)
            {
                isConcrete = false;
                symSource = (SymbolicValue) executionResult.getValue().toRValue();
            }
            else
            {
                super.handle(new AlkException(ERR_CHOOSE_NOT_ITERABLE));
            }
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicChooseState copy = new SymbolicChooseState(tree, getPayload().clone(sm), uniform);
        return super.decorate(copy, sm);
    }
}
