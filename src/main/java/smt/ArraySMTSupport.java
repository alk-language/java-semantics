package smt;

import com.microsoft.z3.*;

public class ArraySMTSupport
{
    private final ArraySort arrayType;
    private final AlkSMTContext alkCtx;

    private ArrayExpr emptyArray;
    private FuncDecl<IntSort> left, right;


    public ArraySMTSupport(AlkSMTContext alkCtx, ArraySort arrayType)
    {
        this.alkCtx = alkCtx;
        this.arrayType = arrayType;
        defineLeftRight();
    }

    public ArrayExpr getEmptyArray()
    {
        if (emptyArray == null)
        {
            String arrayName = "emptyArray_" + alkCtx.getFresh();
            emptyArray = alkCtx.ctx.mkArrayConst(arrayName, alkCtx.ctx.getIntSort(), arrayType.getRange());

            alkCtx.s.add(alkCtx.ctx.mkEq(alkCtx.ctx.mkApp(left, emptyArray), alkCtx.ctx.mkInt(0)));
            alkCtx.s.add(alkCtx.ctx.mkEq(alkCtx.ctx.mkApp(right, emptyArray), alkCtx.ctx.mkInt(0)));
        }
        return emptyArray;
    }

    public FuncDecl<IntSort> getLeft()
    {
        return left;
    }

    public FuncDecl<IntSort> getRight()
    {
        return right;
    }

    private void defineLeftRight()
    {
        String leftName = "left_" + alkCtx.getFresh();
        left = alkCtx.ctx.mkFuncDecl(leftName, arrayType, alkCtx.ctx.getIntSort());
        String rightName = "right_" + alkCtx.getFresh();
        right = alkCtx.ctx.mkFuncDecl(rightName, arrayType, alkCtx.ctx.getIntSort());


        Context ctx = alkCtx.ctx;

        // \forall a \in Array, left(a) <= right(a)
        Expr[] bound = new Expr[] { ctx.mkConst(alkCtx.getFresh(), arrayType) };
        Expr body = ctx.mkLe(ctx.mkApp(left, bound[0]), ctx.mkApp(right, bound[0]));
        alkCtx.s.add(ctx.mkForall(bound, body, 1, null, null, null, null));
    }

    public Expr validateStore(Expr oldValue, Expr position, Expr value)
    {
        Expr lft = alkCtx.getArraySupport((ArraySort) oldValue.getSort()).getLeft().apply(oldValue);
        Expr newValue = alkCtx.ctx.mkStore(oldValue, alkCtx.ctx.mkAdd(position, lft), value);

        Context ctx = alkCtx.ctx;

        // position + 1 <= right(oldValue) - left(oldValue) => left(newValue) = left(oldValue) && right(newValue) = right(oldValue)
        // position + 1 > right(oldValue) - left(oldValue) => left(newValue) = left(oldValue) && right(newValue) == left(oldValue) + position + 1
        Expr<BoolSort> condition = ctx.mkLe(ctx.mkAdd(position, ctx.mkInt(1)), ctx.mkSub(ctx.mkApp(right, oldValue), ctx.mkApp(left, oldValue)));
        Expr<BoolSort> out1 = ctx.mkAnd(ctx.mkEq(ctx.mkApp(left, newValue), ctx.mkApp(left, oldValue)), ctx.mkEq(ctx.mkApp(right, newValue), ctx.mkApp(right, oldValue)));
        Expr<BoolSort> out2 = ctx.mkAnd(ctx.mkEq(ctx.mkApp(left, newValue), ctx.mkApp(left, oldValue)), ctx.mkEq(ctx.mkApp(right, newValue), ctx.mkAdd(ctx.mkApp(left, oldValue), position, ctx.mkInt(1))));
        return ctx.mkAnd(ctx.mkImplies(condition, out1), ctx.mkImplies(ctx.mkNot(condition), out2));
    }

    public Expr validateSelect(Expr oldValue, Expr position)
    {
        Expr lft = alkCtx.getArraySupport((ArraySort) oldValue.getSort()).getLeft().apply(oldValue);
        Expr rgh = alkCtx.getArraySupport((ArraySort) oldValue.getSort()).getRight().apply(oldValue);

        Context ctx = alkCtx.ctx;

        Expr<BoolSort> body1 = ctx.mkLe(lft, ctx.mkAdd(lft, position));
        Expr<BoolSort> body2 = ctx.mkLt(ctx.mkAdd(lft, position), rgh);
        return ctx.mkAnd(body1, body2);
    }

    public Expr applyEqPrefix(Expr leftOp, Expr rightOp, Expr cnt)
    {
        Context ctx = alkCtx.ctx;

        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) leftOp.getSort());
        FuncDecl left = support.getLeft();

        Expr fresh = ctx.mkConst(alkCtx.getFresh(), ctx.getIntSort());
        Expr[] bound = new Expr[] { fresh };
        Expr eqBody = ctx.mkEq(ctx.mkSelect(leftOp, ctx.mkAdd(left.apply(leftOp), fresh)),
                               ctx.mkSelect(rightOp, ctx.mkAdd(left.apply(rightOp), fresh)));
        Expr implBody = ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(0), fresh), ctx.mkLt(fresh, cnt)), eqBody);

        return ctx.mkForall(bound, implBody, 1, null, null, null, null);
    }

    public Expr applyEqSuffix(Expr leftOp, Expr rightOp, Expr cnt)
    {
        Context ctx = alkCtx.ctx;

        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) leftOp.getSort());
        FuncDecl right = support.getRight();

        Expr fresh = ctx.mkConst(alkCtx.getFresh(), ctx.getIntSort());
        Expr[] bound = new Expr[] { fresh };
        Expr eqBody = ctx.mkEq(ctx.mkSelect(leftOp, ctx.mkSub(right.apply(leftOp), fresh, ctx.mkInt(1))),
                               ctx.mkSelect(rightOp, ctx.mkSub(right.apply(rightOp), fresh, ctx.mkInt(1))));
        Expr implBody = ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(0), fresh), ctx.mkLt(fresh, cnt)), eqBody);

        return ctx.mkForall(bound, implBody, 1, null, null, null, null);
    }
}

