package smt;

import ast.enums.BuiltInMethod;
import com.microsoft.z3.*;
import execution.parser.exceptions.AlkException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTTopFrontMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTTopFrontMethod(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    @Override
    public Expr apply(Expr<?> target, Expr<?>[] params)
    {
        if (!(target instanceof ArrayExpr))
        {
            throw new AlkException("Applying topfront built-in method on non-array expression!");
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
        SMTMethodSolver sizeFnc = alkCtx.getBuiltInMethodSolver(BuiltInMethod.SIZE);

        Context ctx = alkCtx.ctx;

        Expr must = ctx.mkLe(ctx.mkInt(1), sizeFnc.apply(target, null));
        Expr body = ctx.mkEq(application, ctx.mkSelect(target, left.apply(target)));

        return ctx.mkImplies(must, body);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("topFront", arrayType, ((ArraySort) arrayType).getRange());
            funcs.put(arrayType, fd);

            Context ctx = alkCtx.ctx;

            // forall fresh: topFront(fresh) == fresh[left(fresh)]
            Expr fresh = ctx.mkConst(alkCtx.getFresh(), arrayType);
            Expr[] bound = new Expr[] { fresh };
            Expr body = doConstraints(arrayType, fd.apply(fresh), fresh, null);

            alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
        }
        return funcs.get(arrayType);
    }
}

