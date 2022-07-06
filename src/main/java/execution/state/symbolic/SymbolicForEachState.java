package execution.state.symbolic;

import ast.AST;
import ast.attr.*;
import ast.enums.BuiltInFunction;
import ast.enums.BuiltInMethod;
import ast.enums.Operator;
import ast.expr.*;
import ast.stmt.ChooseAST;
import ast.stmt.ExprStmtAST;
import ast.stmt.StmtSeqAST;
import ast.stmt.WhileAST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.ListDataTypeAST;
import ast.type.SetDataTypeAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.ForEachState;
import execution.types.AlkIterableValue;
import execution.types.alkInt.AlkInt;
import symbolic.SymbolicValue;
import util.types.Storable;
import visitor.BuiltInMethodHelper;

import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_FORALL_ITERABLE_REQUIRED;

public class SymbolicForEachState
extends ForEachState
{
    public static final String idxName = "\\idx";
    public static final String sourceName = "\\source";
    private SymbolicValue symSource;
    private boolean isConcrete = false;
    private boolean simulate = false;

    public SymbolicForEachState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (simulate)
        {
            return null;
        }
        if (isConcrete)
        {
            return super.makeStep();
        }

        if (symSource == null)
        {
            return request(tree.getChild(0));
        }

        DataTypeAST dataTypeAST = ((ExpressionAST) symSource.toAST()).getDataType(getExec().getPathCondition());
        if (dataTypeAST instanceof ArrayDataTypeAST || dataTypeAST instanceof ListDataTypeAST)
        {
            simulate = true;

            getEnv().define(idxName).setValue(new AlkInt(0));
            getEnv().define(sourceName).setValue(symSource);

            WhileAST whileAst = new WhileAST(tree.getCtx(), false);
            List<AST> children = new ArrayList<>();
            children.add(new RefIDAST(idxName));
            FactorPointMethodAST sizeAST = new FactorPointMethodAST(tree.getCtx());
            sizeAST.addChild(new RefIDAST(sourceName));
            sizeAST.addAttribute(BuiltInMethodASTAttr.class, new BuiltInMethodASTAttr(BuiltInMethod.SIZE));
            children.add(sizeAST);
            whileAst.addChild(RelationalAST.createBinary(Operator.LOWER, children));

            StmtSeqAST body = new StmtSeqAST(tree.getCtx());

            AssignmentAST assignAST = new AssignmentAST(tree.getCtx());
            assignAST.addChild(new RefIDAST(tree.getAttribute(IdASTAttr.class).getId()));
            children.clear();
            children.add(new RefIDAST(sourceName));
            children.add(new RefIDAST(idxName));
            assignAST.addChild(BracketAST.createBinary(Operator.BRACKET, children));
            OpsASTAttr attr = new OpsASTAttr();
            attr.add(Operator.ASSIGN);
            assignAST.addAttribute(OpsASTAttr.class, attr);
            body.addChild(assignAST);

            body.addChild(tree.getChild(1));
            ExprStmtAST incAST = new ExprStmtAST(tree.getCtx());
            children.clear();
            children.add(new RefIDAST(idxName));
            incAST.addChild(PostfixAST.createUnary(Operator.PLUSPLUSRIGHT, children));
            body.addChild(incAST);
            whileAst.addChild(body);

            return request(whileAst);
        }
        else if (dataTypeAST instanceof SetDataTypeAST)
        {
            getEnv().define(sourceName).setValue(symSource);

            WhileAST whileAst = new WhileAST(tree.getCtx(), false);

            List<AST> children = new ArrayList<>();
            FactorPointMethodAST sizeAST = new FactorPointMethodAST(tree.getCtx());
            sizeAST.addChild(new RefIDAST(sourceName));
            sizeAST.addAttribute(BuiltInMethodASTAttr.class, new BuiltInMethodASTAttr(BuiltInMethod.SIZE));
            children.add(sizeAST);
            children.add(new IntAST("0"));

            AST condition = RelationalAST.createBinary(Operator.GREATER, children);
            whileAst.addChild(condition);

            StmtSeqAST body = new StmtSeqAST(tree.getCtx());

            ChooseAST chooseAST = new ChooseAST(tree.getCtx());
            chooseAST.addChild(new RefIDAST(tree.getAttribute(IdASTAttr.class).getId()));
            chooseAST.addChild(new RefIDAST(sourceName));

            ExprStmtAST removeAst = new ExprStmtAST(tree.getCtx());
            AssignmentAST assignAST = new AssignmentAST(tree.getCtx());
            OpsASTAttr attr = new OpsASTAttr();
            attr.add(Operator.ASSIGN);
            assignAST.addAttribute(OpsASTAttr.class, attr);
            assignAST.addChild(new RefIDAST(sourceName));

            List<AST> children2 = new ArrayList<>();
            children2.add(new RefIDAST(sourceName));
            AST singleton = new BuiltinFunctionAST(tree.getCtx());
            singleton.addAttribute(BuiltInFunctionASTAttr.class, new BuiltInFunctionASTAttr(BuiltInFunction.SINGLETONSET));
            singleton.addChild(new RefIDAST(tree.getAttribute(IdASTAttr.class).getId()));
            children2.add(singleton);
            AST setdiff = SetExprAST.createBinary(Operator.SETSUBTRACT, children2);
            assignAST.addChild(setdiff);

            removeAst.addChild(assignAST);

            body.addChild(chooseAST);
            body.addChild(removeAst);
            body.addChild(tree.getChild(1));
            whileAst.addChild(body);

            return request(whileAst);
        }
        else
        {
            super.handle(new AlkException(ERR_FORALL_ITERABLE_REQUIRED));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (simulate)
        {
            return;
        }

        if (isConcrete)
        {
            assign(executionResult);
            return;
        }

        if (symSource == null)
        {
            Storable value = executionResult.getValue().toRValue();
            checkNotNull(value, false);
            if (value instanceof AlkIterableValue)
            {
                isConcrete = true;
                super.assign(executionResult);
            }
            else if (value instanceof SymbolicValue)
            {
                isConcrete = false;
                symSource = (SymbolicValue) value;
            }
            else
            {
                super.handle(new AlkException(ERR_FORALL_ITERABLE_REQUIRED));
            }

        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicForEachState copy = new SymbolicForEachState(tree, payload.clone(sm));
        copy.isConcrete = isConcrete;
        copy.simulate = simulate;
        if (this.symSource != null)
        {
            copy.symSource = (SymbolicValue) this.symSource.weakClone(sm.getLocationMapper());
        }
        return this.decorate(copy, sm);
    }
}
