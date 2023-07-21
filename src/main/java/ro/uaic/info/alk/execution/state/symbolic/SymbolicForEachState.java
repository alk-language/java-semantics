package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInFunctionASTAttr;
import ro.uaic.info.alk.ast.attr.BuiltInMethodASTAttr;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.enums.AlkBuiltInFunction;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.stmt.ChooseAST;
import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.ast.stmt.StmtSeqAST;
import ro.uaic.info.alk.ast.stmt.WhileAST;
import ro.uaic.info.alk.ast.type.ArrayDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.ListDataTypeAST;
import ro.uaic.info.alk.ast.type.SetDataTypeAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.ForEachState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.ast.expr.*;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

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

            getEnv().define(idxName).setValue(AlkInt.ZERO);
            getEnv().define(sourceName).setValue(symSource);

            WhileAST whileAst = new WhileAST(tree.getCtx(), false);
            List<AST> children = new ArrayList<>();
            children.add(new RefIDAST(idxName));
            FactorPointMethodAST sizeAST = new FactorPointMethodAST(tree.getCtx());
            sizeAST.addChild(new RefIDAST(sourceName));
            sizeAST.addAttribute(BuiltInMethodASTAttr.class, new BuiltInMethodASTAttr(AlkBuiltInMethod.SIZE));
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
            sizeAST.addAttribute(BuiltInMethodASTAttr.class, new BuiltInMethodASTAttr(AlkBuiltInMethod.SIZE));
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
            singleton.addAttribute(BuiltInFunctionASTAttr.class, new BuiltInFunctionASTAttr(
               AlkBuiltInFunction.SINGLETONSET));
            singleton.addChild(new RefIDAST(tree.getAttribute(IdASTAttr.class).getId()));
            children2.add(singleton);
            AST setdiff = SetExprAST.createBinary(Operator.SET_SUBTRACT, children2);
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
            super.handle(new AlkException(AlkException.ERR_FORALL_ITERABLE_REQUIRED));
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
                super.handle(new AlkException(AlkException.ERR_FORALL_ITERABLE_REQUIRED));
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
