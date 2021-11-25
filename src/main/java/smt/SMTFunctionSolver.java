package smt;

import com.microsoft.z3.Expr;

public interface SMTFunctionSolver
{
    boolean USE_GLOBAL_DEF = true;
    Expr apply(Expr<?>[] params);
}
