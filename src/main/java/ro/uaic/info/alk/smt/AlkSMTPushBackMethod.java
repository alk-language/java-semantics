package ro.uaic.info.alk.smt;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.AlkException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTPushBackMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTPushBackMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    public Expr<?> apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new AlkException("Applying pushBack built-in method on non-array expression!");
        }
        Sort arrayType = target.getFuncDecl().getRange();
        Expr ans = getFunc(arrayType).apply(target, params[0]);
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
        SMTOperatorSolver eqSolver = alkCtx.getOperatorSolver(Operator.EQUAL);
        SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE);

        Context ctx = alkCtx.ctx;

        Expr body1 = eqSolver.apply(true, application, ctx.mkStore(target, right.apply(target), params[0]));
        Expr body2 = support.validateStore(target, sizeFnc.apply(target, null), params[0]);
        return ctx.mkAnd(body1, body2);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            Sort target = ((ArraySort) arrayType).getRange();
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("pushBack", new Sort[]{ arrayType, target }, arrayType);
            funcs.put(arrayType, fd);

            if (USE_GLOBAL_DEF)
            {
                Context ctx = alkCtx.ctx;

                Expr freshA = ctx.mkConst(alkCtx.getFresh(), arrayType);
                Expr freshX = ctx.mkConst(alkCtx.getFresh(), target);
                Expr[] bound = new Expr[] { freshA, freshX };
                Expr body = doConstraints(arrayType, fd.apply(freshA, freshX), freshA, new Expr[] { freshX });
                alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
            }
        }

        return funcs.get(arrayType);
    }
}
