package ro.uaic.info.alk.smt;

import com.microsoft.z3.Expr;

public interface SMTOperatorSolver
{
    Expr<?> apply(boolean forArray, Expr<?> leftOp, Expr<?> rightOp);
}
