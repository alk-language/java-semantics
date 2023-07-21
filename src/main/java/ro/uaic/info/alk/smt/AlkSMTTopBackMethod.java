package ro.uaic.info.alk.smt;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.AlkException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTTopBackMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTTopBackMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    @Override
    public Expr apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new AlkException("Applying topBack built-in method on non-array expression!");
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
        FuncDecl right = support.getRight();
        SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE);

        Context ctx = alkCtx.ctx;

        Expr must = ctx.mkLe(ctx.mkInt(1), sizeFnc.apply(target, null));
        Expr body = ctx.mkEq(application, ctx.mkSelect(target, ctx.mkSub(right.apply(target), ctx.mkInt(1))));

        return ctx.mkImplies(must, body);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("topBack", arrayType, ((ArraySort) arrayType).getRange());
            funcs.put(arrayType, fd);

            Context ctx = alkCtx.ctx;

            // forall fresh: topBack(fresh) == fresh[right(fresh) - 1]
            Expr fresh = ctx.mkConst(alkCtx.getFresh(), arrayType);
            Expr[] bound = new Expr[] { fresh };
            Expr body = doConstraints(arrayType, fd.apply(fresh), fresh, null);

            alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
        }
        return funcs.get(arrayType);
    }
}
