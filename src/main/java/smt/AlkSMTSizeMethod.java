package smt;

import com.microsoft.z3.*;
import util.exception.SMTUnexpectedException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTSizeMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTSizeMethod(AlkSMTContext alkCtx)
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
        return alkCtx.ctx.mkApp(getFunc(arrayType), target);
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("size", arrayType, alkCtx.ctx.getIntSort());
            funcs.put(arrayType, fd);

            ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) arrayType);
            FuncDecl left = support.getLeft();
            FuncDecl right = support.getRight();
            Context ctx = alkCtx.ctx;

            // \forall a \in Array, size(a) = right(a) - left(a)
            Expr[] bound = new Expr[] { ctx.mkConst(alkCtx.getFresh(), arrayType) };
            Expr body = ctx.mkEq(ctx.mkApp(fd, bound[0]), ctx.mkSub(ctx.mkApp(right, bound[0]), ctx.mkApp(left, bound[0])));
            alkCtx.s.add(ctx.mkForall(bound, body, 1, null, null, null, null));
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
