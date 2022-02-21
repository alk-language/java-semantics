package dataflow.domain;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import control.EdgeData;
import dataflow.Domain;
import execution.BaseStatefulInterpreterManager;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.interpreter.SymbolicStatefulStmtInterpreter;
import execution.parser.env.*;
import execution.state.ExecutionState;
import execution.utils.Stepper;
import symbolic.SymbolicValue;
import util.Configuration;
import util.FuncManager;
import util.pc.PathCondition;
import util.Recurrence;
import util.exception.InternalException;
import util.types.Storable;

import java.util.*;
import java.util.function.Function;

public class ProgramContext
implements Domain
{
    private final List<ExecutionPath> paths = new ArrayList<>();

    public ProgramContext()
    {
    }

    public ProgramContext(ProgramContext ctx)
    {
        for (ExecutionPath path : ctx.paths)
        {
            this.paths.add(new ExecutionPath(path));
        }
    }

    public static ProgramContext getInitialContext()
    {
        ProgramContext ctx = new ProgramContext();
        StoreImpl store = new StoreImpl();
        ctx.addExecutionPath(new ExecutionPath(store, new EnvironmentImpl(store), new PathCondition(false)));
        return ctx;
    }

    public static ProgramContext getEmptyContext()
    {
        return new ProgramContext();
    }

    public void addExecutionPath(ExecutionPath executionPath)
    {
        this.paths.add(executionPath);
    }

    public void union(ProgramContext ctx)
    {
        this.paths.addAll(ctx.paths);
        normalize();
    }

    private void normalize()
    {
        List<ExecutionPath> newPaths = new ArrayList<>();
        Set<String> strings = new HashSet<>();

        for (ExecutionPath path : paths)
        {
            if (!strings.contains(path.toString()))
            {
                newPaths.add(path);
                strings.add(path.toString());
            }
        }
        paths.clear();
        paths.addAll(newPaths);
    }

    public void run(AST tree, EdgeData data)
    {
        for (ExecutionPath path : paths)
        {
            path.run(tree, data);
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ProgramContext))
            return false;
        ProgramContext pc = (ProgramContext) obj;
        if (pc.paths.size() != this.paths.size())
            return false;
        return this.toString().equals(pc.toString());
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("\n");
        List<String> pathString = new ArrayList<>();
        for (ExecutionPath path : paths)
        {
            pathString.add(path.toString());
        }
        Collections.sort(pathString);
        for (String str : pathString)
        {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    public void virtualize(Function<String, Storable> code)
    {
        for (ExecutionPath path : paths)
        {
            path.virtualize(code);
        }
    }

    public void markInside(AST tree)
    {
        for (ExecutionPath path : paths)
        {
            path.markInside(tree);
        }
    }

    public void removeAllInside(AST tree)
    {
        List<ExecutionPath> newPaths = new ArrayList<>();
        for (ExecutionPath path : paths)
        {
            if (!path.isInside(tree))
                newPaths.add(path);
        }
        paths.clear();
        paths.addAll(newPaths);
    }

    public boolean includes(ProgramContext pc)
    {
        Set<String> paths1 = new HashSet<>();
        Set<String> paths2 = new HashSet<>();
        for (ExecutionPath path : this.paths)
        {
            paths1.add(path.toString());
        }
        for (ExecutionPath path : pc.paths)
        {
            paths2.add(path.toString());
        }

        return paths1.containsAll(paths2);
    }

    public Map<String, Recurrence> getReccurences(AST tree)
    {
        Map<String, Recurrence> mapping = new HashMap<>();
        for (ExecutionPath path : paths)
        {
            if (!path.isInside(tree))
            {
                // pre-loop, so initial values
                path.dumpInitial(mapping);
            }
            else
            {
                // post-loop, so recurring values
                path.dumpRecurring(mapping);
            }
        }
        return mapping;
    }
}

class ExecutionPath
{
    private final StoreImpl store;
    private final Environment env;
    private final PathCondition pc;
    private final Set<AST> inside;

    public ExecutionPath(StoreImpl store, EnvironmentImpl env, PathCondition pc)
    {
        this.store = store;
        this.env = env;
        this.pc = pc;
        this.inside = new HashSet<>();
    }

    public ExecutionPath(ExecutionPath path)
    {
        this.store = new StoreImpl();

        LocationMapper locMapping = new LocationMapper(path.store, this.store);
        Set<Location> sourceLocations = path.store.getLocations();

        for (Location loc : sourceLocations)
        {
            Location newLoc = this.store.malloc();
            locMapping.put(loc, newLoc);
        }

        for (Location loc : sourceLocations)
        {
            Storable value = loc.getValue();
            Storable copyValue = value.weakClone(locMapping);
            this.store.set(locMapping.get(loc), copyValue);
        }

        this.env = path.env.makeClone(locMapping, store);
        this.pc = new PathCondition(path.pc, locMapping);
        this.inside = new HashSet<>(path.inside);
    }

    public void run(AST tree, EdgeData data)
    {
        BaseStatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager =
                new BaseStatefulInterpreterManager<>(new SymbolicStatefulExpressionInterpreter(), new SymbolicStatefulStmtInterpreter());
        Storable value = Stepper.run(tree, new Configuration(), env, store, this.pc, new FuncManager(), manager);
        if (data != null)
        {
            if (data.getCondition())
            {
                this.pc.add(SymbolicValue.toSymbolic(value));
            }
            else
            {
                SymbolicValue symVal = SymbolicValue.toSymbolic(value);
                AST negatedAst = UnaryAST.createUnary(Operator.NOT, symVal.toAST());
                this.pc.add(new SymbolicValue(negatedAst));
            }
        }
    }

    public void virtualize(Function<String, Storable> code)
    {
        Set<String> variables = env.getVariables();
        for (String id : variables)
        {
            env.update(id, code.apply(id));
        }
    }

    @Override
    public String toString()
    {
        return "{\n" + "   Environment:\n" +
                env.toString(6) +
                "\n" +
                "   Path Condition:\n" +
                pc.toString(6) +
                "\n}";
    }

    public void markInside(AST tree)
    {
        inside.add(tree);
    }

    public boolean isInside(AST tree)
    {
        return inside.contains(tree);
    }

    public void dumpInitial(Map<String, Recurrence> mapping)
    {
        Set<String> variables = env.getVariables();
        for (String id : variables)
        {
            if (!mapping.containsKey(id))
            {
                mapping.put(id, new Recurrence(id));
            }

            mapping.get(id).addInitial(env.getLocation(id).toRValue(), pc);
        }
    }

    public void dumpRecurring(Map<String, Recurrence> mapping)
    {
        Set<String> variables = env.getVariables();
        for (String id : variables)
        {
            if (!mapping.containsKey(id))
            {
                mapping.put(id, new Recurrence(id));
            }

            mapping.get(id).addRecurring(env.getLocation(id).toRValue(), pc);
        }
    }
}
