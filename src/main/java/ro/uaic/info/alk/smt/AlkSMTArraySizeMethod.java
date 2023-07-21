package ro.uaic.info.alk.smt;

import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.SMTUnexpectedException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTArraySizeMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;
    private final boolean LOCAL_DEF = true;

    public AlkSMTArraySizeMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new SMTUnexpectedException("Applying size built-in method on non-array expression.");
        }
        Sort arrayType = target.getSort();
        Expr ans = alkCtx.ctx.mkApp(getFunc(arrayType), target);

        if (LOCAL_DEF || !USE_GLOBAL_DEF)
        {
            alkCtx.add(doConstraints(arrayType, ans, target, new Expr[] { }));
        }
        return ans;
    }

    private Expr doConstraints(Sort arrayType, Expr application, Expr target, Expr[] params)
    {
        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) arrayType);

        FuncDecl left = support.getLeft();
        FuncDecl right = support.getRight();
        Context ctx = alkCtx.ctx;
        return ctx.mkEq(application, ctx.mkSub(ctx.mkApp(right, target), ctx.mkApp(left, target)));
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("size", arrayType, alkCtx.ctx.getIntSort());
            funcs.put(arrayType, fd);
            if (!LOCAL_DEF && USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;

                Expr freshA = ctx.mkConst(alkCtx.getFresh(), arrayType);
                Expr[] bound = new Expr[] { freshA };
                Expr body = doConstraints(arrayType, fd.apply(freshA), freshA, new Expr[] { });

                alkCtx.s.add(ctx.mkForall(bound, body, 1, null, null, null, null));
            }
        }
        return funcs.get(arrayType);
    }

    public void assumeEquality(Expr array, int size)
    {
        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) array.getSort());
        FuncDecl left = support.getLeft();
        FuncDecl right = support.getRight();
        alkCtx.add(alkCtx.ctx.mkEq(left.apply(array), alkCtx.ctx.mkInt(0)));
        alkCtx.add(alkCtx.ctx.mkEq(right.apply(array), alkCtx.ctx.mkInt(size)));
    }
}
