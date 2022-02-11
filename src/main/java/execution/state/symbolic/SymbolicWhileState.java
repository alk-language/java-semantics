package execution.state.symbolic;

import ast.AST;
import ast.attr.ParamASTAttr;
import ast.enums.Operator;
import ast.expr.RefIDAST;
import ast.expr.UnaryAST;
import ast.stmt.HavocAST;
import execution.*;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.InvariantException;
import execution.parser.exceptions.StopException;
import execution.state.ExecutionCloneContext;
import execution.state.ExecutionState;
import execution.state.statement.WhileState;
import symbolic.SymbolicValue;
import util.exception.InternalException;
import util.pc.PathCondition;
import util.types.Storable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymbolicWhileState
extends WhileState
{
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
    private boolean spawned = false;

    private int firstStepInv = 0;
    private int middleStepInv = 0;

    private Storable checkingInvariant;

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

        if (!checkedInvariant && firstStepInv < invariants.size())
        {
            return request(invariants.get(firstStepInv));
        }

        // do havoc and check initial invariants
        if (!doneInternalHavoc)
        {
            for (int i = 0; i < invariants.size(); i++)
            {
                processInvariant(invariantValues.get(i), invariants.get(i));
            }
            invariantValues.clear();

            doHavoc();
            doneInternalHavoc = true;
        }

        // check condition
        if (!checkedCondition)
        {
            return request(condition);
        }

        // check invariant
        if (!checkedInternalInvariant && middleStepInv < invariants.size())
        {
            return request(invariants.get(middleStepInv));
        }

        if (!spawned)
        {
            spawned = true;

            for (Storable value : invariantValues)
            {
                // assume invariant
                getExec().getPathCondition().add((SymbolicValue) value);
                if (!getExec().getPathCondition().isSatisfiable())
                {
                    super.handle(new AlkException("Can't assume invariant: " + value.toString()));
                }
            }

            Storable cond = conditionValue.clone(generator);
            ExecutionPool pool = new ExecutionPool();
            ExecutionCloneContext ctx = getExec().clone(pool);
            ctx.exec.getPathCondition().add((SymbolicValue) cond.weakClone(ctx.locMapping));
            ctx.exec.start();

            getExec().getPathCondition().add(new SymbolicValue(
                    UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) conditionValue).toAST())));

            return null;
        }

        // assume condition and invariant
        if (!doneInternalAssume)
        {
            getExec().getPathCondition().add((SymbolicValue) conditionValue.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume condition!"));
            }

            doneInternalAssume = true;
        }

        if (!doneBody)
        {
            return request(body);
        }

        if (!doneFinalInvariant)
        {
            return request(invariants.get(stepInv));
        }

        if (!checkedFinalInvariant)
        {
            processInvariant(checkingInvariant, invariants.get(stepInv));
            checkedFinalInvariant = true;
        }

        getExec().halt();
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
                vars.add(attr.getParameter(i).getName());
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

        if (!checkedInvariant && firstStepInv < invariants.size())
        {
            invariantValues.add(executionResult.getValue().toRValue());
            firstStepInv++;
            if (firstStepInv == invariants.size())
            {
                checkedInvariant = true;
            }
        }
        else if (!checkedCondition)
        {
            checkedCondition = true;
            conditionValue = executionResult.getValue().toRValue();
        }
        else if (!checkedInternalInvariant && middleStepInv < invariants.size())
        {
            invariantValues.add(executionResult.getValue().toRValue());
            middleStepInv++;
            if (middleStepInv == invariants.size())
            {
                checkedInternalInvariant = true;
            }
        }
        else if (!doneBody)
        {
            doneBody = true;
        }
        else if (!doneFinalInvariant)
        {
            doneFinalInvariant = true;
            checkingInvariant = executionResult.getValue().toRValue();
        }
        else if (!checkedExternCondition)
        {
            checkedExternCondition = true;
            conditionValue = executionResult.getValue().toRValue();
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
    protected boolean processInvariant(Storable invariantValue, AST invariant)
    {
        if (invariantValue instanceof SymbolicValue)
        {
            try
            {
                if (!getExec().getPathCondition().asserts((SymbolicValue) invariantValue))
                {
                    throw new AlkException("Loop invariant violation!");
                }
            }
            catch (InternalException e)
            {
                e.sign(invariant.getLine(), invariant.getColumn());
                throw e;
            }
        }
        else
        {
            return super.processInvariant(invariantValue, invariant);
        }

        return true;
    }

    private boolean hasInvariant()
    {
        return super.invariants != null && !super.invariants.isEmpty();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicWhileState copy = new SymbolicWhileState(tree, payload.clone(sm));

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

        copy.firstStepInv = firstStepInv;
        copy.middleStepInv = middleStepInv;
        copy.spawned = spawned;

        copy.checkingInvariant = this.checkingInvariant == null ? null :
                this.checkingInvariant.weakClone(sm.getLocationMapper());

        return super.decorate(copy, sm);
    }
}
