package ro.uaic.info.alk.smt;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Sort;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTAtanFunction
implements SMTFunctionSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTAtanFunction(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?>[] params)
    {
        Sort paramType = params[0].getSort();
        Expr ans = getFunc(paramType).apply(params[0]);
        if (!USE_GLOBAL_DEF)
        {
            alkCtx.add(doConstraints(paramType, ans, params));
        }
        return ans;
    }

    private Expr doConstraints(Sort paramType, Expr application, Expr[] params)
    {
        return alkCtx.ctx.mkBool(true);
    }

    private FuncDecl<?> getFunc(Sort paramType)
    {
        if (!funcs.containsKey(paramType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("atan", new Sort[]{ paramType }, alkCtx.ctx.getRealSort());
            funcs.put(paramType, fd);

            if (USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;

                Expr fresh = ctx.mkConst(alkCtx.getFresh(), paramType);

                Expr[] bound = new Expr[] { fresh };
                Expr body = doConstraints(paramType, fd.apply(fresh), new Expr[] { fresh });
                alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
            }
        }

        return funcs.get(paramType);
    }
}

