package ro.uaic.info.alk.smt;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import com.microsoft.z3.ArraySort;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;

public class EqualOperatorSolver
implements SMTOperatorSolver
{
    private final AlkSMTContext alkCtx;

    public EqualOperatorSolver(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    @Override
    public Expr<?> apply(boolean forArray, Expr leftOp, Expr rightOp)
    {
        if (forArray)
        {
            Context ctx = alkCtx.ctx;
            Expr leftSize = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE).apply(leftOp, null);
            Expr rightSize = alkCtx.getBuiltInMethodSolver(AlkBuiltInMethod.SIZE).apply(rightOp, null);
            Expr first = ctx.mkEq(leftSize, rightSize);

            ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) leftOp.getSort());
            FuncDecl left = support.getLeft();

            Expr fresh = ctx.mkConst(alkCtx.getFresh(), ctx.getIntSort());
            Expr[] bound = new Expr[] { fresh };
            Expr eqBody = ctx.mkEq(ctx.mkSelect(leftOp, ctx.mkAdd(left.apply(leftOp), fresh)),
                                   ctx.mkSelect(rightOp, ctx.mkAdd(left.apply(rightOp), fresh)));
            Expr implBody = ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(0), fresh), ctx.mkLt(fresh, leftSize)), eqBody);

            Expr second = ctx.mkForall(bound, implBody, 1, null, null, null, null);
            return ctx.mkAnd(first, second);
        }
        return alkCtx.ctx.mkEq(leftOp, rightOp);
    }
}
