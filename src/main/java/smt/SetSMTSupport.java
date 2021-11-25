package smt;

import com.microsoft.z3.*;

public class SetSMTSupport
{
    private final ArraySort setType;
    private final AlkSMTContext alkCtx;
    private ArrayExpr emptySet;


    public SetSMTSupport(AlkSMTContext alkCtx, ArraySort setType)
    {
        this.alkCtx = alkCtx;
        this.setType = setType;
    }

    public ArrayExpr getEmptySet()
    {
        if (emptySet == null)
        {
            String arrayName = "emptySet_" + alkCtx.getFresh();
            emptySet = alkCtx.ctx.mkArrayConst(arrayName, setType.getDomain(), alkCtx.ctx.getBoolSort());

            Context ctx = alkCtx.ctx;
            Expr fresh = ctx.mkConst(alkCtx.getFresh(), setType.getDomain());
            Expr[] bound = new Expr[] { fresh };
            Expr body = alkCtx.ctx.mkEq(ctx.mkSelect(emptySet, fresh), ctx.mkBool(false));
            alkCtx.add(alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null));
        }
        return emptySet;
    }
}
