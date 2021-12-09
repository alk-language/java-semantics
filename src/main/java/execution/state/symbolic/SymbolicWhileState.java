package execution.state.symbolic;

import ast.AST;
import ast.attr.ParamASTAttr;
import ast.enums.Operator;
import ast.expr.RefIDAST;
import ast.expr.UnaryAST;
import ast.stmt.HavocAST;
import execution.Execution;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.InvariantException;
import execution.state.ExecutionCloneContext;
import execution.state.ExecutionState;
import execution.state.statement.WhileState;
import symbolic.SymbolicValue;
import util.types.Storable;

import java.util.HashSet;
import java.util.Set;

public class SymbolicWhileState
extends WhileState
{
    private boolean processedInitialInvariant = false;
    private boolean doneInternalHavoc = false;
    private boolean doneInternalAssume = false;
    private boolean checkedInternalInvariant = false;
    private boolean doneBody = false;
    private boolean doneFinalInvariant = false;
    private boolean checkedFinalInvariant = false;
    private boolean doneFinalHavoc = false;
    private boolean checkedExternCondition = false;
    private boolean checkedExternInvariant = false;
    private boolean doneExternal = false;

    public SymbolicWhileState(AST tree, ExecutionPayload payload)
    {
        super(tree, payload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (!hasInvariant())
        {
            return super.makeStep();
        }

        if (broke)
        {
            setResult(new ExecutionResult(null));
            return null;
        }

        if (!checkedInvariant)
        {
            return request(invariant);
        }

        // do initial check (proof check 1)
        if (!processedInitialInvariant)
        {
            try
            {
                processInvariant(invariantValue);
            }
            catch (InvariantException e)
            {
                super.handle(new InvariantException("Loop invariant violated on entry"));
            }
            processedInitialInvariant = true;
        }

        // do havoc
        if (!doneInternalHavoc)
        {
            doHavoc();
            doneInternalHavoc = true;
        }

        // check condition
        if (!checkedCondition)
        {
            return request(condition);
        }

        // check invariant
        if (!checkedInternalInvariant)
        {
            return request(invariant);
        }

        // assume condition and invariant
        if (!doneInternalAssume)
        {
            getExec().getPathCondition().add((SymbolicValue) conditionValue.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume condition!"));
            }
            getExec().getPathCondition().add((SymbolicValue) invariantValue.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume invariant!"));
            }

            doneInternalAssume = true;
        }

        if (!doneBody)
        {
            return request(body);
        }

        if (!doneFinalInvariant)
        {
            return request(invariant);
        }

        if (!checkedFinalInvariant)
        {
            try
            {
                processInvariant(invariantValue);
            }
            catch (InvariantException e)
            {
                super.handle(e);
            }
            checkedFinalInvariant = true;
        }

        if (!doneFinalHavoc)
        {
            doHavoc();
            doneFinalHavoc = true;
        }

        // check condition
        if (!checkedExternCondition)
        {
            return request(condition);
        }

        // check invariant
        if (!checkedExternInvariant)
        {
            return request(invariant);
        }

        if (!doneExternal)
        {
            AST negated = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) conditionValue.toRValue()).toAST());
            getExec().getPathCondition().add(new SymbolicValue(negated));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume condition!"));
            }
            getExec().getPathCondition().add((SymbolicValue) invariantValue.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume invariant!"));
            }

            doneExternal = true;
        }


        return null;
    }

    private void doHavoc()
    {
        HavocAST havoc = new HavocAST(null);
        ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
        Set<String> vars = new HashSet<>();
        if (attr != null)
        {
            for (int i = 0; i < attr.getParamCount(); i++)
            {
                vars.add(attr.getParameter(i).y);
            }
        }
        else
        {
            vars = getEnv().getVariables();
        }
        for (String nod : vars)
        {
            havoc.addChild(new RefIDAST(nod));
        }
        SymHavocState state = new SymHavocState(havoc, payload);
        state.makeStep();
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!hasInvariant())
        {
            super.assign(executionResult);
            return;
        }

        if (!checkedInvariant)
        {
            checkedInvariant = true;
            invariantValue = executionResult.getValue().toRValue();
        }
        else if (!checkedCondition)
        {
            checkedCondition = true;
            conditionValue = executionResult.getValue().toRValue();
        }
        else if (!checkedInternalInvariant)
        {
            checkedInternalInvariant = true;
            invariantValue = executionResult.getValue().toRValue();
        }
        else if (!doneBody)
        {
            doneBody = true;
        }
        else if (!doneFinalInvariant)
        {
            doneFinalInvariant = true;
            invariantValue = executionResult.getValue().toRValue();
        }
        else if (!checkedExternCondition)
        {
            checkedExternCondition = true;
            conditionValue = executionResult.getValue().toRValue();
        }
        else if (!checkedExternInvariant)
        {
            checkedExternInvariant = true;
            invariantValue = executionResult.getValue().toRValue();
        }
        else
        {
            checkedInternalInvariant = false;
            checkedCondition = false;
            checkedInvariant = false;
            validCondition = false;
        }
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
        Execution outExec = cloneCtx.exec;
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
    protected boolean processInvariant(Storable invariantValue)
    {
        if (invariantValue instanceof SymbolicValue)
        {
            if (!getExec().getPathCondition().asserts((SymbolicValue) invariantValue))
            {
                throw new InvariantException("Loop invariant violation!");
            }
        }
        else
        {
            return super.processInvariant(invariantValue);
        }

        return true;
    }

    private boolean hasInvariant()
    {
        return super.invariant != null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicWhileState copy = new SymbolicWhileState(tree, payload.clone(sm));
        copy.processedInitialInvariant = processedInitialInvariant;
        copy.doneInternalHavoc = doneInternalHavoc;
        copy.doneInternalAssume = doneInternalAssume;
        copy.checkedInternalInvariant = checkedInternalInvariant;
        copy.doneBody = doneBody;
        copy.doneFinalInvariant = doneFinalInvariant;
        copy.checkedFinalInvariant = checkedFinalInvariant;
        copy.doneFinalHavoc = doneFinalHavoc;
        copy.checkedExternCondition = checkedExternCondition;
        copy.checkedExternInvariant = checkedExternInvariant;
        copy.doneExternal = doneExternal;
        return super.decorate(copy, sm);
    }
}
