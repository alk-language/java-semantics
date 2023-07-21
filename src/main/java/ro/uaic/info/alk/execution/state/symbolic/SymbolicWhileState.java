package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInMethodASTAttr;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.stmt.DeclAST;
import ro.uaic.info.alk.ast.stmt.HavocAST;
import ro.uaic.info.alk.ast.stmt.WhileAST;
import ro.uaic.info.alk.ast.type.ArrayDataTypeAST;
import ro.uaic.info.alk.ast.type.ListDataTypeAST;
import ro.uaic.info.alk.ast.type.SetDataTypeAST;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionCloneContext;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.WhileState;
import ro.uaic.info.alk.types.AlkIterableValue;
import ro.uaic.info.alk.types.ConcreteValue;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.ast.expr.EqualityAST;
import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.expr.FactorPointMethodAST;
import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionPool;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

import java.util.*;

public class SymbolicWhileState
extends WhileState
{
    private boolean doneInternalHavoc = false;
    private boolean doneInternalAssume = false;
    private boolean checkedInternalInvariant = false;
    private boolean checkedLoopAssert = false;
    private boolean doneBody = false;
    private boolean doneFinalInvariant = false;
    private boolean checkedFinalInvariant = false;
    private boolean doneFinalHavoc = false;
    private boolean checkedExternInvariant = false;
    private boolean doneExternal = false;
    private boolean spawned = false;

    private int firstStepInv = 0;
    private int middleStepInv = 0;
    private int finalStepInv = 0;

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

        if (!checkedLoopAssert && ((WhileAST) tree).hasLoopAssert())
        {
            return request(((WhileAST) tree).getLoopAssert());
        }

        if (!spawned)
        {
            spawned = true;

            for (int i = 0; i < invariants.size(); i++)
            {
                Storable value = invariantValues.get(i);

                // assume invariant
                if (value instanceof ConcreteValue)
                {
                    super.processInvariant(value, invariants.get(i));
                }
                else
                {
                    getExec().getPathCondition().add((SymbolicValue) value);
                    if (!getExec().getPathCondition().isSatisfiable())
                    {
                        super.handle(new AlkException("Can't assume invariant: " + value.toString()));
                    }
                }
            }

            invariantValues.clear();

            Storable cond = conditionValue.clone(generator);
            ExecutionPool pool = new ExecutionPool();
            ExecutionCloneContext ctx = getExec().clone(pool);
            ctx.exec.getPathCondition().add((SymbolicValue) cond.weakClone(ctx.locMapping));
            ctx.exec.start();

            getExec().getPathCondition().add(new SymbolicValue(
               UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) conditionValue).toAST())));

            if (loopAssertValue != null)
            {
                getExec().getConfig().getIOManager().write("[WARNING] Loop assert is not properly supported yet!");
                if (loopAssertValue instanceof SymbolicValue)
                {
                    try
                    {
                        if (!getExec().getPathCondition().asserts((SymbolicValue) loopAssertValue))
                        {
                            throw new AlkException("Loop assert violation!");
                        }
                    }
                    catch (InternalException e)
                    {
                        e.sign(((WhileAST) tree).getLoopAssert().getLine(), ((WhileAST) tree).getLoopAssert().getColumn());
                        throw e;
                    }
                }
                else
                {
                    if (loopAssertValue instanceof AlkBool)
                    {
                        AlkBool bool = (AlkBool) loopAssertValue;
                        if (!bool.isTrue())
                        {
                            super.handle(new AlkException("Loop assert is not valid."));
                        }
                    }
                    else
                    {
                        super.handle(new AlkException("Loop assert must be boolean."));
                    }
                }
            }

            return null;
        }

        // assume condition and invariant
        if (!doneInternalAssume)
        {
            getExec().getPathCondition().add((SymbolicValue) conditionValue.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Can't assume condition: " + conditionValue));
            }

            doneInternalAssume = true;
        }

        if (!doneBody)
        {
            return request(body);
        }

        if (!checkedFinalInvariant && finalStepInv < invariants.size())
        {
            return request(invariants.get(finalStepInv));
        }

        for (int i = 0; i < invariants.size(); i++)
        {
            Storable value = invariantValues.get(i);
            this.processInvariant(value, invariants.get(i));
            getConfig().getIOManager().write("[" + invariants.get(i).getLine() + ":" +
                    invariants.get(i).getColumn() + "] Loop invariant was verified!");
            getConfig().getIOManager().flush();
        }

        getExec().halt();
        return null;
    }

    private void doHavoc()
    {
        HavocAST havoc = new HavocAST(null);
        Set<String> vars = new HashSet<>();

        Set<String> hasSize = new HashSet<>();
        if (tree.hasAttribute(ParamASTAttr.class))
        {
            ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
            for (int i = 0; i < attr.getParamCount(); i++)
            {
                if (attr.getParameter(i).hasSizeFlag())
                {
                    hasSize.add(attr.getParameter(i).getName());
                }
                else
                {
                    vars.add(attr.getParameter(i).getName());
                }
            }
        }
        else
        {
            vars = getEnv().getVariables();
        }

        Map<String, SymbolicValue> sizes = new HashMap<>();
        for (String nod : vars)
        {
            Storable currentValue = getEnv().getLocation(nod).toRValue();
            if (currentValue instanceof AlkIterableValue)
            {
                sizes.put(nod, SymbolicValue.toSymbolic(((AlkIterableValue) currentValue).size()));
            }
            if (currentValue instanceof SymbolicValue)
            {
                AST dataType = ((ExpressionAST) ((SymbolicValue) currentValue).toAST()).getDataType(getExec().getPathCondition());
                if (dataType instanceof ArrayDataTypeAST || dataType instanceof ListDataTypeAST || dataType instanceof SetDataTypeAST)
                {
                    FactorPointMethodAST fpm = new FactorPointMethodAST(null);
                    BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.SIZE);
                    fpm.addAttribute(BuiltInMethodASTAttr.class, attr);
                    fpm.addChild(((SymbolicValue) currentValue).toAST());
                    sizes.put(nod, new SymbolicValue(fpm));
                }
            }
            AST ast = new DeclAST(null);
            IdASTAttr attr = new IdASTAttr(nod);
            ast.addAttribute(IdASTAttr.class, attr);
            havoc.addChild(ast);
        }

        SymHavocState state = new SymHavocState(havoc, payload);
        state.makeStep();

        for (String nod : vars)
        {
            if (hasSize.contains(nod) || !sizes.containsKey(nod))
            {
                continue;
            }

            Storable currentValue = getEnv().getLocation(nod).toRValue();
            FactorPointMethodAST fpm = new FactorPointMethodAST(null);
            BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.SIZE);
            fpm.addAttribute(BuiltInMethodASTAttr.class, attr);
            fpm.addChild(((SymbolicValue) currentValue).toAST());

            List<AST> children = new ArrayList<>();
            children.add(fpm);
            children.add(sizes.get(nod).toAST());
            EqualityAST eqAST = EqualityAST.createBinary(Operator.EQUAL, children);

            getExec().getPathCondition().add(new SymbolicValue(eqAST));
        }
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
        else if (!checkedLoopAssert && ((WhileAST) tree).hasLoopAssert())
        {
            loopAssertValue = executionResult.getValue().toRValue();
            checkedLoopAssert = true;
        }
        else if (!doneBody)
        {
            doneBody = true;
        }
        else if (!checkedFinalInvariant)
        {
            invariantValues.add(executionResult.getValue().toRValue());
            finalStepInv++;
            if (finalStepInv == invariants.size())
            {
                checkedFinalInvariant = true;
            }
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
        AlkExecution outExec = cloneCtx.exec;
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
//                    System.out.println("Path condition: " + getExec().getPathCondition());
//                    System.out.println("Invariant: " + invariantValue);
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
        copy.checkedLoopAssert = checkedLoopAssert;
        copy.doneBody = doneBody;
        copy.doneFinalInvariant = doneFinalInvariant;
        copy.checkedFinalInvariant = checkedFinalInvariant;
        copy.doneFinalHavoc = doneFinalHavoc;
        copy.checkedExternInvariant = checkedExternInvariant;
        copy.doneExternal = doneExternal;

        copy.firstStepInv = firstStepInv;
        copy.middleStepInv = middleStepInv;
        copy.finalStepInv = finalStepInv;

        copy.spawned = spawned;

        return super.decorate(copy, sm);
    }
}
