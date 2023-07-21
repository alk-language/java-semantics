package ro.uaic.info.alk.smt;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.AlkException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTPopFrontMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTPopFrontMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new AlkException("Applying popFront built-in method on non-array expression!");
        }
        Sort arrayType = target.getFuncDecl().getRange();
        Expr ans = getFunc(arrayType).apply(target);
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

        Expr body1 = support.applyEqSuffix(application, target, sizeFnc.apply(application, null));
        Expr body2 = ctx.mkEq(left.apply(application), ctx.mkAdd(left.apply(target), ctx.mkInt(1)));
        Expr body3 = ctx.mkEq(right.apply(application), right.apply(target));
        Expr body4 = ctx.mkLe(ctx.mkInt(1), sizeFnc.apply(target, null));
        return ctx.mkAnd(body1, body2, body3, body4);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("popFront", arrayType, arrayType);
            funcs.put(arrayType, fd);


            if (USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;
                SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE);
                Expr freshA = ctx.mkConst(alkCtx.getFresh(), arrayType);
                Expr[] bound = new Expr[] { freshA };
                Expr must = ctx.mkLe(ctx.mkInt(1), sizeFnc.apply(freshA, null));
                Expr body = ctx.mkImplies(must, doConstraints(arrayType, fd.apply(freshA), freshA, null));
                alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
            }
        }
        return funcs.get(arrayType);
    }
}

