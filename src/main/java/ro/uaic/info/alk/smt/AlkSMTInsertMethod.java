package ro.uaic.info.alk.smt;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.AlkException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTInsertMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTInsertMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new AlkException("Applying insert built-in method on non-array expression!");
        }
        Sort arrayType = target.getFuncDecl().getRange();
        Expr ans = getFunc(arrayType).apply(target, params[0], params[1]);
        if (!USE_GLOBAL_DEF)
        {
            alkCtx.add(doConstraints(arrayType, ans, target, params));
        }
        return ans;
    }

    private Expr doConstraints(Sort arrayType, Expr application, Expr target, Expr[] params)
    {
        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) arrayType);
        FuncDecl left = support.getLeft();
        FuncDecl right = support.getRight();
        SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE);

        Context ctx = alkCtx.ctx;

        Expr body0 = ctx.mkEq(left.apply(application), left.apply(target));
        Expr body1 = ctx.mkEq(right.apply(application), ctx.mkAdd(right.apply(target), ctx.mkInt(1)));
        Expr body2 = support.applyEqPrefix(application, target, params[0]);
        Expr body3 = support.applyEqSuffix(application, target, ctx.mkSub(sizeFnc.apply(target, null), params[0]));
        Expr body4 = ctx.mkEq(ctx.mkSelect(application, ctx.mkAdd(left.apply(target), params[0])), params[1]);
        Expr body5 = ctx.mkAnd(ctx.mkLe(ctx.mkInt(0), params[0]), ctx.mkLe(params[0], sizeFnc.apply(target, null)));
        return ctx.mkAnd(body0, body1, body2, body3, body4, body5);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            Sort position = alkCtx.ctx.getIntSort();
            Sort value = ((ArraySort) arrayType).getRange();
            SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE);

            FuncDecl fd = alkCtx.ctx.mkFuncDecl("insert", new Sort[]{ arrayType, position, value }, arrayType);
            funcs.put(arrayType, fd);

            if (USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;

                Expr freshA = ctx.mkConst(alkCtx.getFresh(), arrayType);
                Expr freshI = ctx.mkConst(alkCtx.getFresh(), position);
                Expr freshX = ctx.mkConst(alkCtx.getFresh(), value);

                Expr[] bound = new Expr[] { freshA, freshI, freshX };
                Expr must = ctx.mkAnd(ctx.mkLe(ctx.mkInt(0), freshI), ctx.mkLe(freshI, sizeFnc.apply(freshA, null)));
                Expr body = doConstraints(arrayType, fd.apply(freshA, freshI, freshX), freshA, new Expr[] { freshI, freshX });
                alkCtx.add(alkCtx.ctx.mkForall(bound, ctx.mkImplies(must, body), 1, null, null, null, null));
            }
        }

        return funcs.get(arrayType);
    }
}

