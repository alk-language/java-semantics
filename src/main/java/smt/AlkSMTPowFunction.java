package smt;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Sort;
import util.Pair;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTPowFunction
implements SMTFunctionSolver
{
    private final Map<Pair<Sort, Sort>, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTPowFunction(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?>[] params)
    {
        Sort paramType0 = params[0].getSort();
        Sort paramType1 = params[1].getSort();
        Expr ans = getFunc(new Pair<>(paramType0, paramType1)).apply(params[0], params[1]);
        if (!USE_GLOBAL_DEF)
        {
            alkCtx.add(doConstraints(new Pair<>(paramType0, paramType1), ans, params));
        }
        return ans;
    }

    private Expr doConstraints(Pair<Sort, Sort> paramType, Expr application, Expr[] params)
    {
        return alkCtx.ctx.mkBool(true);
    }

    private FuncDecl<?> getFunc(Pair<Sort, Sort> paramType)
    {
        if (!funcs.containsKey(paramType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("pow", new Sort[]{ paramType.x, paramType.y }, alkCtx.ctx.getRealSort());
            funcs.put(paramType, fd);

            if (USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;

                Expr fresh0 = ctx.mkConst(alkCtx.getFresh(), paramType.x);
                Expr fresh1 = ctx.mkConst(alkCtx.getFresh(), paramType.y);

                Expr[] bound = new Expr[] { fresh0, fresh1 };
                Expr body = doConstraints(paramType, fd.apply(fresh0, fresh1), new Expr[] { fresh0, fresh1 });
                alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
            }
        }

        return funcs.get(paramType);
    }
}

