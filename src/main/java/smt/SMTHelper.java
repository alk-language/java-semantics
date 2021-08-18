package smt;

import ast.AST;
import ast.type.DataTypeAST;
import symbolic.SymbolicValue;
import util.Configuration;
import util.PathCondition;
import com.microsoft.z3.*;
import util.exception.SMTUnimplementedException;

import java.util.HashMap;
import java.util.Map;

public class SMTHelper
{
    public static boolean validatePathCondition(Configuration config, PathCondition condition)
    {
        Context ctx = new Context();
        Goal g = ctx.mkGoal(true, false, false);

        try
        {
            processCondition(condition, ctx, g);
        }
        catch (SMTUnimplementedException e)
        {
            if (config.hasDebugMode())
            {
                config.getIOManager().write(e.getMessage());
            }
            return true;
        }

        Solver s = ctx.mkSolver();
        for (BoolExpr a : g.getFormulas()) s.add(a);
        Status status = s.check();
        return status == Status.SATISFIABLE;
    }

    private static void processCondition(PathCondition condition, Context ctx, Goal g)
    {
        Map<String, DataTypeAST> idTypes = condition.getIdTypes();
        Map<String, Expr<?>> ids = new HashMap<>();
        for (Map.Entry<String, DataTypeAST> entry : idTypes.entrySet())
        {
            ids.put(entry.getKey(), entry.getValue().makeExpr(ctx, entry.getKey()));
        }
        SMTVisitor visitor = new SMTVisitor(ctx, g, ids);
        for (SymbolicValue value : condition.getConditions())
        {
            AST root = value.toAST();
            Expr expr = root.accept(visitor);
            g.add(expr);
        }
    }
}
