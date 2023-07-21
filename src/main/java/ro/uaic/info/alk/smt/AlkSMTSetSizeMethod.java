package ro.uaic.info.alk.smt;

import com.microsoft.z3.*;
import ro.uaic.info.alk.exeptions.SMTUnexpectedException;

import java.util.HashMap;
import java.util.Map;

public class AlkSMTSetSizeMethod
implements SMTMethodSolver
{
    private final Map<Sort, FuncDecl<?>> funcs = new HashMap<>();
    private final AlkSMTContext alkCtx;

    public AlkSMTSetSizeMethod(AlkSMTContext alkCtx)
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

        return ans;
    }

    private FuncDecl<?> getFunc(Sort arrayType)
    {
        if (!funcs.containsKey(arrayType))
        {
            FuncDecl fd = alkCtx.ctx.mkFuncDecl("size", arrayType, alkCtx.ctx.getIntSort());
            funcs.put(arrayType, fd);
        }
        return funcs.get(arrayType);
    }
}

